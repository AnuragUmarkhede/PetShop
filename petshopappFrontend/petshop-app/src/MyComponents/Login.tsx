import * as React from 'react';
import Button from '@mui/material/Button';
import CssBaseline from '@mui/material/CssBaseline';
import TextField from '@mui/material/TextField';
import Link from '@mui/material/Link';
import Grid from '@mui/material/Grid';
import Box from '@mui/material/Box';
import Typography from '@mui/material/Typography';
import Container from '@mui/material/Container';
import { createTheme, ThemeProvider } from '@mui/material/styles';
import { useState } from "react";
import { Avatar } from '@mui/material';
import LockOpenIcon from '@mui/icons-material/LockOpen';

const theme = createTheme();


export default function SignIn() {
  // const [username] = useState("bhavana");
  // const [password] = useState("bhavana");
  const handleSubmit = (event: React.FormEvent<HTMLFormElement>) => {
    event.preventDefault();
    const data = new FormData(event.currentTarget);
   const uname = sessionStorage.getItem("username");
   const pass = sessionStorage.getItem("password");
    if(data.get('username')==uname && data.get('password')==pass){
      alert("Login Successfull!!");
      window.location.replace("http://localhost:3000/home");
    }
    else if(data.get('username')=="" && data.get('password')==""){
      alert("Fields cant be Empty")
    }
    else{
      alert("Wrong Credentials!!")
    }
    
    console.log({
      email: data.get('email'),
      password: data.get('password'),
    });
  };

  return (
    <Box padding={10}>
    <ThemeProvider theme={theme}>
      <Container component="main" maxWidth="xs">
        <CssBaseline />
        <Box
          sx={{
            marginTop: 8,
            display: 'flex',
            flexDirection: 'column',
            alignItems: 'center',
          }}
        >
         
         <Avatar  sx={{ bgcolor: '#9575cd' }} variant="rounded">
          <LockOpenIcon/>
         </Avatar>
          <Typography component="h1" variant="h5">
            Sign in
          </Typography>
          <Box component="form" onSubmit={handleSubmit} noValidate sx={{ mt: 1 }}>
            <TextField
              margin="normal"
              required
              fullWidth
              id="email"
              label="Email Address"
              name="username"
              autoComplete="email"
              autoFocus
            />
            <TextField
              margin="normal"
              required
              fullWidth
              name="password"
              label="Password"
              type="password"
              id="password"
              autoComplete="current-password"
            />
            
            <Button
              type="submit"
              fullWidth
              variant="contained"
              sx={{ mt: 3, mb: 2 }}
            >
              Sign In
            </Button>
            <Grid container>
              <Grid item xs>
                <Link href="#"
                 variant="body2"
                 sx={{ my: 2, color: "blue", display: "block" }}>
                  Forgot password?
                </Link>
              </Grid>
              <Grid item>
                <Link href="/register"
                 variant="body2"
                 sx={{ my: 2, color: "red", display: "block" }}>
                  {"Don't have an account? Sign Up"}
                </Link>
              </Grid>
            </Grid>
          </Box>
        </Box>
        
      </Container>
    </ThemeProvider>
    </Box>
  );
  
}
