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
