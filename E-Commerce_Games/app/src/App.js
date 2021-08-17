import "./App.css";
import MainPage from "./pages/main";
import ConfirmationPage from "./pages/confirmation";
import PurchasePage from "./pages/purchase";
import { BrowserRouter as Router, Switch, Route } from "react-router-dom";
import { ItemsProvider } from "./cartItemsContext";

function App() {
	return (
		<Router>
			<ItemsProvider>
				<Switch>
					<Route exact path="/">
						<MainPage />
					</Route>
					<Route exact path="/purchase">
						<PurchasePage />
					</Route>
					<Route exact path="/confirm">
						<ConfirmationPage />
					</Route>
				</Switch>
			</ItemsProvider>
		</Router>
	);
}

export default App;
