<?xml version='1.0'?>
<xsl:stylesheet version="1.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform">
<xsl:template match="/">
	<html>
		<head><title>Peliculillas</title></head>
		<body bgcolor="#87AEC5">
			<h1 align="center">VIDEOS COMPARTIDOS</h1>
			
			<table border="0" align="center">
			<xsl:for-each select="/playList/trackList/track">
				<tr>
				<td>
				<a>
				<xsl:attribute name="href">player.jsp?url=<xsl:value-of select="./location"/></xsl:attribute>
				<img height="100" width="150">
					<xsl:attribute name="src">
						<xsl:value-of select="./image"/>
					</xsl:attribute>
				</img>
				</a>
				</td>
				<td>
					<b>Título:</b>
					<xsl:value-of select="./title"/><br/>
					<b>Id:</b>
					<xsl:value-of select="./identifier"/><br/>
					<a>
						<xsl:attribute name="href">
							<xsl:value-of select="./location"/>
						</xsl:attribute>
						Descargar video:
					</a><br/>
					<xsl:value-of select="./annotation"/>		
				</td>
				</tr>
			</xsl:for-each>
			</table>
		</body>
	</html>
</xsl:template>
</xsl:stylesheet>		