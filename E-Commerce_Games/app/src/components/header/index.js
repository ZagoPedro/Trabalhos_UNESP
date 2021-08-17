
// ====================================================================================================================  //

//  https://github.com/ZagoPedro - pedro_zago.costa@terra.com.br                                                         //
//  https://github.com/Daviiro - david.junior@unesp.br                                                                   //
//  https://github.com/ceconcarlsen - ceconcarlsen@gmail.com

// ====================================================================================================================  //


import React, { useState, useContext, setState } from "react";
import {
	StyledHeadder,
	StyledLogo,
	StyledMid,
	StyledLogin,
	SyledCartPic,
	SyledLoginPic,
	ButtonBadge,
	StyledWebsiteLogo,
} from "./style";
import { Link } from "react-router-dom";
import { ItensCarrinho } from "../../cartItemsContext";

const Header = (props) => {
	const [CartItems] = useContext(ItensCarrinho);
	const CountCartItems = CartItems.length;

	return (
		<StyledHeadder>
			<StyledLogo>
				<Link to="/">
					<StyledWebsiteLogo src="/assets/Logo_1.png" />
				</Link>
			</StyledLogo>
			<StyledMid></StyledMid>
			<StyledLogin>
				<Link to="/login">
					<SyledLoginPic src="/assets/loginPic.png" />
				</Link>
				<Link to="/purchase">
					<SyledCartPic src="/assets/cartPic.png" />
					{""}
					{CountCartItems ? (
						<ButtonBadge>{CountCartItems}</ButtonBadge>
					) : (
						""
					)}
				</Link>
			</StyledLogin>
		</StyledHeadder>
	);
};

export default Header;
