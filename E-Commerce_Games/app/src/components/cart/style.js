import styled from "styled-components";

export const StyledCart = styled.main`
	grid-area: main;
	max-width: 1080px;
	margin: 0 auto;
	background-color: #151d27;
	color: #ffffff;
	display: flex;
	justify-content: space-around;
	align-items: flex-start;
	flex-wrap: wrap;
	flex-direction: column;
	padding: 0.5rem;
	a {
		text-decoration: none;
	}
`;

export const SyledHR = styled.hr`
	display: block;
	width: 70%;
	margin-top: 0.5em;
	margin-bottom: 0.5em;
	margin-left: auto;
	margin-right: auto;
	border-style: inset;
	border-width: 1px;
`;

export const ButtonS = styled.button`
	font-size: 0.8rem;
	padding: 0.2rem;
	margin: 0.1rem;
	border-radius: 0.5rem;
	border: 0.1rem #404040 solid;
	background-color: #f0c040;
	width: 100%;
	cursor: pointer;
`;

export const ButtonAdd = styled(ButtonS)`
	background-color: #40c0f0;
	width: 1.5rem;
`;

export const ButtonSub = styled(ButtonS)`
	background-color: #f04040;
	width: 1.5rem;
`;

export const ButtonDel = styled(ButtonS)`
	background-color: #f6f6f6;
	width: 2rem;
`;

export const ButtonConfirm = styled(ButtonS)`
	background-color: #f6f6f6;
	width: 6rem;
`;

export const MiniaturePic = styled.img`
	width: 6rem;
	height: 8rem;
	margin: 0.5rem 1.5rem;
`;

export const ProdutoContainer = styled.div`
	display: flex;
	flex-direction: row;
	align-items: center;
`;
