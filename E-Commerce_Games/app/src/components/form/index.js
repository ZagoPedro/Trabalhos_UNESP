
// ====================================================================================================================  //

//  https://github.com/ZagoPedro - pedro_zago.costa@terra.com.br                                                         //
//  https://github.com/Daviiro - david.junior@unesp.br                                                                   //
//  https://github.com/ceconcarlsen - ceconcarlsen@gmail.com

// ====================================================================================================================  //


import React from "react";
import { StyledForm } from "./style";
import { createMuiTheme } from "@material-ui/core/styles";
import { ThemeProvider } from "@material-ui/styles";
import { Link } from "react-router-dom";
import { Button } from "@material-ui/core";
import { purple } from "@material-ui/core/colors";

import TextField from "@material-ui/core/TextField";

const theme = createMuiTheme({
	palette: {
		primary: {
			// Purple and green play nicely together.
			main: purple[500],
		},
		secondary: {
			// This is green.A700 as hex.
			main: "#11cb5f",
		},
	},
});

const Form = () => {
	return (
		<StyledForm>
			<ThemeProvider theme={theme}>
				<TextField
					style={{ backgroundColor: "white", borderRadius: "5px" }}
					color="primary"
					id="outlined-basic"
					label="Nome"
					variant="filled"
				/>
				<TextField
					style={{ backgroundColor: "white", borderRadius: "5px" }}
					color="primary"
					id="outlined-basic"
					label="Cidade"
					variant="filled"
				/>
				<TextField
					style={{ backgroundColor: "white", borderRadius: "5px" }}
					color="primary"
					id="outlined-basic"
					label="Bairro"
					variant="filled"
				/>
				<TextField
					style={{ backgroundColor: "white", borderRadius: "5px" }}
					color="primary"
					id="outlined-basic"
					label="Rua"
					variant="filled"
				/>
				<TextField
					style={{ backgroundColor: "white", borderRadius: "5px" }}
					color="primary"
					id="outlined-basic"
					label="Número"
					variant="filled"
				/>
				<Link to="/">
					<Button variant="contained" color="primary">
						Confirmar
					</Button>
				</Link>
			</ThemeProvider>
		</StyledForm>
	);
};

export default Form;
