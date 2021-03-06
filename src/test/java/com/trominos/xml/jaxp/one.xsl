<?xml version="1.0" encoding="ISO-8859-1"?>

<xsl:stylesheet 
  xmlns:xsl="http://www.w3.org/1999/XSL/Transform" 
  version="1.0"
  >
  <xsl:output method="xml"/> 
  <xsl:strip-space elements="SECT"/>
 
  <xsl:template match="/">
    <myxml>
       <xsl:apply-templates/>
    </myxml>
  </xsl:template>

  <xsl:template match="/ARTICLE/TITLE">
    <mytitle> <xsl:apply-templates/>  </mytitle>
  </xsl:template>

  <!-- Top Level Heading -->
  <xsl:template match="/ARTICLE/SECT">
      <one><xsl:apply-templates select="text()|B|I|U|DEF|LINK"/> </one>
      <xsl:apply-templates select="SECT|PARA|LIST|NOTE"/>
  </xsl:template>
    
  <!-- Second-Level Heading -->
  <xsl:template match="/ARTICLE/SECT/SECT">
      <two> <xsl:apply-templates select="text()|B|I|U|DEF|LINK"/> </two>
      <xsl:apply-templates select="SECT|PARA|LIST|NOTE"/>
  </xsl:template>

  <!-- Third-Level Heading -->
  <xsl:template match="/ARTICLE/SECT/SECT/SECT">
     <xsl:message terminate="yes">Error: Sections can only be nested 2 deep.</xsl:message>
  </xsl:template>

  <!-- Paragraph -->
  <xsl:template match="PARA">
      <!-- MODIFIED -->
      <!-- OLD: <p><xsl:apply-templates/></p> -->
      <p> <xsl:apply-templates select="text()|B|I|U|DEF|LINK"/> </p>
      <xsl:apply-templates select="PARA|LIST|NOTE"/>
  </xsl:template>

  <!-- Text -->
  <xsl:template match="text()">
    <xsl:value-of select="normalize-space()"/>
  </xsl:template>

  <!-- LIST  -->
  <xsl:template match="LIST">
    <xsl:if test="@type='ordered'">
      <ol>
      <xsl:apply-templates/>
      </ol>
    </xsl:if>
    <xsl:if test="@type='unordered'">
      <ul>
      <xsl:apply-templates/>
      </ul>
    </xsl:if>
  </xsl:template>

  <!-- list ITEM -->
  <xsl:template match="ITEM">
    <li><xsl:apply-templates/>
    </li>
  </xsl:template>

  <xsl:template match="NOTE">
    <blockquote><b>Note:</b><br/>
      <xsl:apply-templates/>
    </blockquote>
  </xsl:template>

</xsl:stylesheet>


