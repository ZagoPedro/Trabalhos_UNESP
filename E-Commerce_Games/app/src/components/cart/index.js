
// ====================================================================================================================  //

//  https://github.com/ZagoPedro - pedro_zago.costa@terra.com.br                                                         //
//  https://github.com/Daviiro - david.junior@unesp.br                                                                   //
//  https://github.com/ceconcarlsen - ceconcarlsen@gmail.com

// ====================================================================================================================  //


import React, { useContext } from "react";
import { ItensCarrinho } from "../../cartItemsContext";
import {
	StyledCart,
	SyledHR,
	ButtonAdd,
	ButtonSub,
	ButtonDel,
	ButtonConfirm,
	MiniaturePic,
	ProdutoContainer,
} from "./style";
import Button from "@material-ui/core/Button";
import { Link } from "react-router-dom";

const Cart = () => {
	const [CartItems, setCartItems] = useContext(ItensCarrinho);
	const itemsPrice = CartItems.reduce((a, c) => a + c.preco * c.qtd, 0);
	const shippingPrice = itemsPrice > 2000 ? 0 : 50;
	const totalPrice = itemsPrice + shippingPrice;

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

	const handleSub = (produto) => {
		const exist = CartItems.find((x) => x._id === produto._id);
		if (exist.qtd === 1) {
			setCartItems(CartItems.filter((x) => x._id !== produto._id));
		} else {
			setCartItems(
				CartItems.map((x) =>
					x._id === produto._id ? { ...exist, qtd: exist.qtd - 1 } : x
				)
			);
		}
	};

	const handleDel = (produto) => {
		const exist = CartItems.find((x) => x._id === produto._id);
		if (exist) {
			setCartItems(CartItems.filter((x) => x._id !== produto._id));
		}
	};

	return (
		<StyledCart>
			<div>
				{CartItems.length === 0 ? (
					<h2> Carrinho Vazio </h2>
				) : (
					<h2>Itens no carrinho</h2>
				)}
			</div>
			{CartItems.map((item) => (
				<div key={item._id}>
					<ProdutoContainer>
						<MiniaturePic
							src={process.env.PUBLIC_URL + item.image}
						/>
						<div>
							<div>{item.nome}</div>
							<div>
								<ButtonAdd onClick={() => handleAdd(item)}>
									+
								</ButtonAdd>
								<ButtonSub onClick={() => handleSub(item)}>
									-
								</ButtonSub>
								<ButtonDel onClick={() => handleDel(item)}>
									DEL
								</ButtonDel>
							</div>
							<div>
								{item.qtd} X R${item.preco.toFixed(2)}
							</div>
						</div>
					</ProdutoContainer>
				</div>
			))}
			{CartItems.length !== 0 && (
				<>
					<SyledHR></SyledHR>
					<div>
						<div>Preço</div>
						<div>R${itemsPrice.toFixed(2)}</div>
					</div>

					<div>
						<div>Preço Frete</div>
						<div>R${shippingPrice.toFixed(2)}</div>
					</div>
					<div>
						<div>
							<strong>Total</strong>
						</div>
						<div>R${totalPrice.toFixed(2)}</div>
					</div>
					<SyledHR />
					<Link to="/confirm">
						<Button variant="contained" color="primary">
							Confirmar Compra
						</Button>
					</Link>
				</>
			)}
		</StyledCart>
	);
};

export default Cart;
