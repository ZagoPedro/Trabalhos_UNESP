import React from "react";
import Header from "../../components/header";
import Cart from "../../components/cart";
import { GridContainer } from "../pagesStyle";
import Footer from "../../components/footer";

const PurchasePage = () => {
	return (
		<GridContainer>
			<Header />
			<Cart />
			<Footer />
		</GridContainer>
	);
};

export default PurchasePage;
