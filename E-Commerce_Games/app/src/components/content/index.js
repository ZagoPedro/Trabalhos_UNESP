import React, { useState, useContext } from "react";
import Produto from "./produto";
import data from "../../data/products";
import { StyledContent, StyledProductsList, StyledMainHeader } from "./style";
import { ItensCarrinho } from "../../cartItemsContext";
import SearchBar from "material-ui-search-bar";

const Content = () => {
	const [CartItems, setCartItems] = useContext(ItensCarrinho);
	const [search, setSearch] = useState("");

	const handleAdd = (produto) => {
		const exist = CartItems.find((x) => x._id === produto._id);
		if (exist) {
			setCartItems(
				CartItems.map((x) =>
					x._id === produto._id ? { ...exist, qtd: exist.qtd + 1 } : x
				)
			);
		} else {
			setCartItems([...CartItems, { ...produto, qtd: 1 }]);
		}
	};

	return (
		<>
			<StyledContent>
				<StyledMainHeader>
					<SearchBar
						value={search}
						onChange={(newValue) => setSearch(newValue)}
					/>
				</StyledMainHeader>

				<StyledProductsList>
					{data.produtos
						.filter((val) => {
							if (search == "") {
								return val;
							} else if (
								val.nome
									.toLowerCase()
									.includes(search.toLowerCase())
							) {
								return val;
							} else if (
								val.categoria
									.toLowerCase()
									.includes(search.toLowerCase())
							) {
								return val;
							}
						})
						.map((produto) => (
							<Produto produto={produto} handleAdd={handleAdd} />
						))}
				</StyledProductsList>
			</StyledContent>
		</>
	);
};

export default Content;
