
// ====================================================================================================================  //

//  https://github.com/ZagoPedro - pedro_zago.costa@terra.com.br                                                         //
//  https://github.com/Daviiro - david.junior@unesp.br                                                                   //
//  https://github.com/ceconcarlsen - ceconcarlsen@gmail.com

// ====================================================================================================================  //


import React from "react";
import Header from "../../components/header";
import { GridContainer } from "../pagesStyle";
import Footer from "../../components/footer";
import Form from "../../components/form";

const MainPage = () => {
	return (
		<GridContainer>
			<Header />
			<Form />
			<Footer />
		</GridContainer>
	);
};

export default MainPage;
