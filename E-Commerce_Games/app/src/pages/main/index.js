import React from "react";
import Header from "../../components/header";
import Content from "../../components/content";
import Footer from "../../components/footer";
import { GridContainer } from "../pagesStyle";

const ConfirmationPage = () => {
	return (
		<GridContainer>
			<Header />
			<Content />
			<Footer />
		</GridContainer>
	);
};

export default ConfirmationPage;
