import styled from "styled-components";

export const StyledFooter = styled.footer`
	grid-area: footer;
	background-color: #010610;
	min-height: 220px;
	height: auto;
	color: #ffffff;
	display: flex;
	justify-content: space-between;
	flex-direction: column;
	align-items: center;
	padding: 0.5rem;
`;

export const StyledSocialMediaDiv = styled.div`
	margin: 0 auto;
	max-width: 1080px;
	padding: 0 10px;
`;

export const StyledCopyrightDiv = styled.div`
	margin: 0 auto;
	max-width: 1080px;
	padding: 0 10px;
	display: flex;
	flex-direction: row;
	align-items: center;
	justify-content: center;
	a {
		text-decoration: none;
		color: white;
	}
`;

export const SyledHR = styled.hr`
	display: block;
	width: 55%;
	margin-top: 0.5em;
	margin-bottom: 0.5em;
	margin-left: auto;
	margin-right: auto;
	border-style: inset;
	border-width: 1px;
`;

export const StyledFooterIMG = styled.img`
	width: 110px;
	height: 55px;
	margin: 0 10px;
`;

export const StyledH5 = styled.h5`
	text-align: center;
	margin-right: 10px;
	margin-left: 10px;
`;
