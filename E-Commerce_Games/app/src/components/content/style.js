import styled from "styled-components";

export const StyledContent = styled.main`
	grid-area: main;
	min-width: 990px;
	max-width: 1080px;
	margin: 0 auto;
	background-color: #151d27;
	color: #ffffff;
`;

export const StyledMainHeader = styled.div`
	display: flex;
	justify-content: space-between;
	align-items: flex-start;
	flex-wrap: wrap;
	flex-direction: row;
	padding: 1rem;
`;

export const StyledProductsList = styled.div`
	display: flex;
	justify-content: space-between;
	align-items: flex-start;
	flex-wrap: wrap;
	flex-direction: row;
	padding: 0.5rem;
`;
