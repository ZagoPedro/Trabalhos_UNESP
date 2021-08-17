import styled from "styled-components";

export const GridContainer = styled.div`
	display: grid;
	grid-gap: 20px;
	grid-template-areas:
		"header"
		"main"
		"footer";
	grid-template-columns: 1fr;
	grid-template-rows: 5rem 1fr 5rem;
	height: 100%;
`;
