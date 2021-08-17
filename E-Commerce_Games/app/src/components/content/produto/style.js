import styled from "styled-components";

export const Imagem = styled.div`
	img {
		width: 100%;
		height: auto;
		border-top-left-radius: 4px;
		border-top-right-radius: 4px;
	}
`;

export const StyledProduto = styled.div`
	max-width: 11rem;
	height: 23rem;
	margin: 0.5rem;
	word-wrap: break-word;
	background-color: #263240;
	border-bottom-left-radius: 4px;
	border-bottom-right-radius: 4px;
	a {
		text-decoration: none;
		color: #ffffff;
	}
	li {
		list-style-type: none;
	}
`;

export const StyledProdutoInfos = styled.div`
	padding: 0 5px 2px;
	min-height: 95px;
	display: flex;
	flex-direction: column;
	justify-content: space-between;
`;

export const StyledButtonAdd = styled.button`
	background-color: #384656;
	color: white;
	width: 100%;
	border-radius: 5px;
	border: 1px solid #ffffff;
	cursor: pointer;
`;
