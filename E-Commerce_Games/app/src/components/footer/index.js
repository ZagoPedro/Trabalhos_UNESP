import React from "react";
import {
	StyledFooter,
	SyledHR,
	StyledSocialMediaDiv,
	StyledCopyrightDiv,
	StyledFooterIMG,
	StyledH5,
} from "./style";

const Footer = () => {
	return (
		<StyledFooter>
			<StyledSocialMediaDiv>
				<StyledH5>Social Media</StyledH5>
				<a href="https://www.discord.com">
					<StyledFooterIMG src="/assets/Discord_Logo.png" />
				</a>
				<a href="https://www.facebook.com">
					<StyledFooterIMG src="/assets/Facebook_Logo.png" />
				</a>
				<a href="https://www.instagram.com">
					<StyledFooterIMG src="/assets/Instagram_Logo.png" />
				</a>
				<a href="https://www.twitch.com">
					<StyledFooterIMG src="/assets/Twitch_Logo.png" />
				</a>
				<a href="https://www.twitter.com">
					<StyledFooterIMG src="/assets/Twitter_Logo.png" />
				</a>
				<a href="https://www.youtube.com">
					<StyledFooterIMG src="/assets/YouTube_Logo.png" />
				</a>
			</StyledSocialMediaDiv>
			<SyledHR />
			<StyledCopyrightDiv>
				<a href="#">
					<StyledH5>Termos de Uso</StyledH5>
				</a>
				<a href="#">
					<StyledH5>Política de Privacidade</StyledH5>
				</a>
				<a href="#">
					<StyledH5>Copyright © 2018-2021</StyledH5>
				</a>
			</StyledCopyrightDiv>
		</StyledFooter>
	);
};

export default Footer;
