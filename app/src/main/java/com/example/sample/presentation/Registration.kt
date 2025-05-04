package com.example.sample.presentation

import android.widget.Toast
import androidx.annotation.ColorRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Phone
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.CornerRadius
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.sample.R
import com.example.sample.presentation.utilities.CustomTextField

@Preview(showSystemUi = true)
@Composable
fun Registration(){

    val context = LocalContext.current
    var firstName by remember { mutableStateOf("") }
    var lastName by remember { mutableStateOf("") }
    var email by remember { mutableStateOf("") }
    var phoneNo by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    var confirmPassword by remember { mutableStateOf("") }

    Column(modifier = Modifier
        .fillMaxSize()
        .padding(12.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(text = "Sign Up",
            textAlign = TextAlign.Start,
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 8.dp),
            fontWeight = FontWeight.Bold,
            fontSize = 25.sp
        )

        CustomTextField(
            value = firstName,
            onValueChange = {firstName = it},
            label = "First Name",
            leadingIcon = Icons.Default.Person,
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 4.dp),
        )

        CustomTextField(
            value = lastName,
            onValueChange = {lastName = it},
            label = "Last Name",
            leadingIcon = Icons.Default.Person,
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 4.dp),
        )

        CustomTextField(
            value = email,
            onValueChange = {email = it},
            label = "Email",
            leadingIcon = Icons.Default.Email,
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 4.dp),
        )

        CustomTextField(
            value = phoneNo,
            onValueChange = {phoneNo = it},
            label = "Phone Number",
            leadingIcon = Icons.Default.Phone,
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 4.dp),
        )

        CustomTextField(
            value = password,
            onValueChange = {password = it},
            label = "Password",
            leadingIcon = Icons.Default.Lock,
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 4.dp),
            visualTransformation = PasswordVisualTransformation()
        )

        CustomTextField(
            value = confirmPassword,
            onValueChange = {confirmPassword = it},
            label = "Confirm Password",
            leadingIcon = Icons.Default.Lock,
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 4.dp),
            visualTransformation = PasswordVisualTransformation()
        )

        Button(
            modifier = Modifier.fillMaxWidth()
                .padding(vertical = 10.dp),
            contentPadding = PaddingValues(5.dp),
            shape = RoundedCornerShape(8.dp),
            colors = ButtonDefaults.buttonColors(colorResource(id = R.color.orange)),
            onClick = {
                if(firstName.isNotEmpty() && lastName.isNotEmpty() && email.isNotEmpty() && phoneNo.isNotEmpty() && password.isNotEmpty() && confirmPassword.isNotEmpty()){
                    if(password == confirmPassword){
                        Toast.makeText(context, "You have successfully Registered", Toast.LENGTH_SHORT).show()
                    }else{
                        Toast.makeText(context, "password and confirm password missmatch", Toast.LENGTH_SHORT).show()
                    }
                }
                else{
                    Toast.makeText(context, "Please make sure to fill all details", Toast.LENGTH_SHORT).show()
                }
            }
        ) {

            Text(text = "Sign up")

        }

        Row(modifier = Modifier.padding(vertical = 8.dp),
            verticalAlignment = Alignment.CenterVertically

        ) {

            Text("Already have an account?",
                fontSize = 14.sp,
                fontWeight = FontWeight.Bold)
            TextButton(onClick = {},) {
                Text("Login", color = colorResource(id = R.color.orange),
                    fontSize = 15.sp,
                    fontWeight = FontWeight.Bold
                )
            }


        }

        Row(modifier = Modifier.padding(vertical = 8.dp),
            verticalAlignment = Alignment.CenterVertically

        ) {
            HorizontalDivider(modifier = Modifier.weight(1.5f))
            Text(text = "OR", modifier = Modifier.padding(horizontal = 8.dp),
                fontSize = 13.sp,
                fontWeight = FontWeight.Bold)
            HorizontalDivider(modifier = Modifier.weight(1.5f))
        }

        OutlinedButton(
            onClick = {},
            modifier = Modifier.fillMaxWidth()
                .padding(vertical = 8.dp),
            shape = RoundedCornerShape(8.dp)
        ) {
            Image(painter = painterResource(id = R.drawable.google_logo),
                contentDescription = null,
                modifier = Modifier.size(24.dp))
            Spacer(modifier = Modifier.size(8.dp))
            Text("Login with Google")
        }
    }
}