import styled from "styled-components";

export const StyledHeadder = styled.header`
	grid-area: header;
	background-color: #151d27;
	box-shadow: 0 3px 25px -2px #000000;
	color: #ffffff;
	display: flex;
	justify-content: space-between;
	align-items: center;
	padding: 0.5rem;
`;

export const StyledLogo = styled.div`
	height: 100%;
	width: 15%;
	padding: 2px 5px;
	display: flex;
	justify-content: space-around;
`;

export const StyledMid = styled.div`
	height: 100%;
	width: 35%;
	display: flex;
	align-items: center;
	justify-content: space-around;
`;

export const StyledLogin = styled.div`
	height: 100%;
	width: 15%;
	display: flex;
	justify-content: space-around;
	align-items: center;
	padding: 0 10px;
`;

export const SyledCartPic = styled.img`
	width: 50px;
	height: 28px;
`;

export const SyledLoginPic = styled.img`
	width: 70px;
	height: 30px;
`;

export const StyledWebsiteLogo = styled.img`
	width: 60px;
	height: 60px;
`;

export const ButtonBadge = styled.button`
	background-color: #f04040;
	border: none;
	color: #ffffff;
	width: 1.5rem;
`;
