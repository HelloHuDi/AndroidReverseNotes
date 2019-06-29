.class La/b/b/a/k$b;
.super La/b/b/a/k$e;
.source ""


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = La/b/b/a/k;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0xa
    name = "b"
.end annotation


# instance fields
.field private d:[I

.field e:La/b/c/a/a/b;

.field f:F

.field g:La/b/c/a/a/b;

.field h:F

.field i:I

.field j:F

.field k:F

.field l:F

.field m:F

.field n:Landroid/graphics/Paint$Cap;

.field o:Landroid/graphics/Paint$Join;

.field p:F


# direct methods
.method public constructor <init>()V
    .locals 3

    .line 1817
    invoke-direct {p0}, La/b/b/a/k$e;-><init>()V

    .line 1802
    const/4 v0, 0x0

    iput v0, p0, La/b/b/a/k$b;->f:F

    .line 1805
    const/high16 v1, 0x3f800000    # 1.0f

    iput v1, p0, La/b/b/a/k$b;->h:F

    .line 1807
    const/4 v2, 0x0

    iput v2, p0, La/b/b/a/k$b;->i:I

    .line 1808
    iput v1, p0, La/b/b/a/k$b;->j:F

    .line 1809
    iput v0, p0, La/b/b/a/k$b;->k:F

    .line 1810
    iput v1, p0, La/b/b/a/k$b;->l:F

    .line 1811
    iput v0, p0, La/b/b/a/k$b;->m:F

    .line 1813
    sget-object v0, Landroid/graphics/Paint$Cap;->BUTT:Landroid/graphics/Paint$Cap;

    iput-object v0, p0, La/b/b/a/k$b;->n:Landroid/graphics/Paint$Cap;

    .line 1814
    sget-object v0, Landroid/graphics/Paint$Join;->MITER:Landroid/graphics/Paint$Join;

    iput-object v0, p0, La/b/b/a/k$b;->o:Landroid/graphics/Paint$Join;

    .line 1815
    const/high16 v0, 0x40800000    # 4.0f

    iput v0, p0, La/b/b/a/k$b;->p:F

    .line 1819
    return-void
.end method

.method public constructor <init>(La/b/b/a/k$b;)V
    .locals 3
    .param p1, "copy"    # La/b/b/a/k$b;

    .line 1822
    invoke-direct {p0, p1}, La/b/b/a/k$e;-><init>(La/b/b/a/k$e;)V

    .line 1802
    const/4 v0, 0x0

    iput v0, p0, La/b/b/a/k$b;->f:F

    .line 1805
    const/high16 v1, 0x3f800000    # 1.0f

    iput v1, p0, La/b/b/a/k$b;->h:F

    .line 1807
    const/4 v2, 0x0

    iput v2, p0, La/b/b/a/k$b;->i:I

    .line 1808
    iput v1, p0, La/b/b/a/k$b;->j:F

    .line 1809
    iput v0, p0, La/b/b/a/k$b;->k:F

    .line 1810
    iput v1, p0, La/b/b/a/k$b;->l:F

    .line 1811
    iput v0, p0, La/b/b/a/k$b;->m:F

    .line 1813
    sget-object v0, Landroid/graphics/Paint$Cap;->BUTT:Landroid/graphics/Paint$Cap;

    iput-object v0, p0, La/b/b/a/k$b;->n:Landroid/graphics/Paint$Cap;

    .line 1814
    sget-object v0, Landroid/graphics/Paint$Join;->MITER:Landroid/graphics/Paint$Join;

    iput-object v0, p0, La/b/b/a/k$b;->o:Landroid/graphics/Paint$Join;

    .line 1815
    const/high16 v0, 0x40800000    # 4.0f

    iput v0, p0, La/b/b/a/k$b;->p:F

    .line 1823
    iget-object v0, p1, La/b/b/a/k$b;->d:[I

    iput-object v0, p0, La/b/b/a/k$b;->d:[I

    .line 1825
    iget-object v0, p1, La/b/b/a/k$b;->e:La/b/c/a/a/b;

    iput-object v0, p0, La/b/b/a/k$b;->e:La/b/c/a/a/b;

    .line 1826
    iget v0, p1, La/b/b/a/k$b;->f:F

    iput v0, p0, La/b/b/a/k$b;->f:F

    .line 1827
    iget v0, p1, La/b/b/a/k$b;->h:F

    iput v0, p0, La/b/b/a/k$b;->h:F

    .line 1828
    iget-object v0, p1, La/b/b/a/k$b;->g:La/b/c/a/a/b;

    iput-object v0, p0, La/b/b/a/k$b;->g:La/b/c/a/a/b;

    .line 1829
    iget v0, p1, La/b/b/a/k$b;->i:I

    iput v0, p0, La/b/b/a/k$b;->i:I

    .line 1830
    iget v0, p1, La/b/b/a/k$b;->j:F

    iput v0, p0, La/b/b/a/k$b;->j:F

    .line 1831
    iget v0, p1, La/b/b/a/k$b;->k:F

    iput v0, p0, La/b/b/a/k$b;->k:F

    .line 1832
    iget v0, p1, La/b/b/a/k$b;->l:F

    iput v0, p0, La/b/b/a/k$b;->l:F

    .line 1833
    iget v0, p1, La/b/b/a/k$b;->m:F

    iput v0, p0, La/b/b/a/k$b;->m:F

    .line 1835
    iget-object v0, p1, La/b/b/a/k$b;->n:Landroid/graphics/Paint$Cap;

    iput-object v0, p0, La/b/b/a/k$b;->n:Landroid/graphics/Paint$Cap;

    .line 1836
    iget-object v0, p1, La/b/b/a/k$b;->o:Landroid/graphics/Paint$Join;

    iput-object v0, p0, La/b/b/a/k$b;->o:Landroid/graphics/Paint$Join;

    .line 1837
    iget v0, p1, La/b/b/a/k$b;->p:F

    iput v0, p0, La/b/b/a/k$b;->p:F

    .line 1838
    return-void
.end method

.method private a(ILandroid/graphics/Paint$Cap;)Landroid/graphics/Paint$Cap;
    .locals 1
    .param p1, "id"    # I
    .param p2, "defValue"    # Landroid/graphics/Paint$Cap;

    .line 1841
    if-eqz p1, :cond_2

    const/4 v0, 0x1

    if-eq p1, v0, :cond_1

    const/4 v0, 0x2

    if-eq p1, v0, :cond_0

    .line 1849
    return-object p2

    .line 1847
    :cond_0
    sget-object v0, Landroid/graphics/Paint$Cap;->SQUARE:Landroid/graphics/Paint$Cap;

    return-object v0

    .line 1845
    :cond_1
    sget-object v0, Landroid/graphics/Paint$Cap;->ROUND:Landroid/graphics/Paint$Cap;

    return-object v0

    .line 1843
    :cond_2
    sget-object v0, Landroid/graphics/Paint$Cap;->BUTT:Landroid/graphics/Paint$Cap;

    return-object v0
.end method

.method private a(ILandroid/graphics/Paint$Join;)Landroid/graphics/Paint$Join;
    .locals 1
    .param p1, "id"    # I
    .param p2, "defValue"    # Landroid/graphics/Paint$Join;

    .line 1854
    if-eqz p1, :cond_2

    const/4 v0, 0x1

    if-eq p1, v0, :cond_1

    const/4 v0, 0x2

    if-eq p1, v0, :cond_0

    .line 1862
    return-object p2

    .line 1860
    :cond_0
    sget-object v0, Landroid/graphics/Paint$Join;->BEVEL:Landroid/graphics/Paint$Join;

    return-object v0

    .line 1858
    :cond_1
    sget-object v0, Landroid/graphics/Paint$Join;->ROUND:Landroid/graphics/Paint$Join;

    return-object v0

    .line 1856
    :cond_2
    sget-object v0, Landroid/graphics/Paint$Join;->MITER:Landroid/graphics/Paint$Join;

    return-object v0
.end method

.method private a(Landroid/content/res/TypedArray;Lorg/xmlpull/v1/XmlPullParser;Landroid/content/res/Resources$Theme;)V
    .locals 12
    .param p1, "a"    # Landroid/content/res/TypedArray;
    .param p2, "parser"    # Lorg/xmlpull/v1/XmlPullParser;
    .param p3, "theme"    # Landroid/content/res/Resources$Theme;

    .line 1883
    const/4 v0, 0x0

    iput-object v0, p0, La/b/b/a/k$b;->d:[I

    .line 1890
    const-string v0, "pathData"

    invoke-static {p2, v0}, La/b/c/a/a/i;->a(Lorg/xmlpull/v1/XmlPullParser;Ljava/lang/String;)Z

    move-result v0

    .line 1891
    .local v0, "hasPathData":Z
    if-nez v0, :cond_0

    .line 1894
    return-void

    .line 1897
    :cond_0
    const/4 v1, 0x0

    invoke-virtual {p1, v1}, Landroid/content/res/TypedArray;->getString(I)Ljava/lang/String;

    move-result-object v1

    .line 1899
    .local v1, "pathName":Ljava/lang/String;
    if-eqz v1, :cond_1

    .line 1900
    iput-object v1, p0, La/b/b/a/k$e;->b:Ljava/lang/String;

    .line 1902
    :cond_1
    const/4 v2, 0x2

    .line 1903
    invoke-virtual {p1, v2}, Landroid/content/res/TypedArray;->getString(I)Ljava/lang/String;

    move-result-object v2

    .line 1904
    .local v2, "pathData":Ljava/lang/String;
    if-eqz v2, :cond_2

    .line 1905
    invoke-static {v2}, La/b/c/b/b;->a(Ljava/lang/String;)[La/b/c/b/b$b;

    move-result-object v3

    iput-object v3, p0, La/b/b/a/k$e;->a:[La/b/c/b/b$b;

    .line 1908
    :cond_2
    const/4 v8, 0x1

    const/4 v9, 0x0

    const-string v7, "fillColor"

    move-object v4, p1

    move-object v5, p2

    move-object v6, p3

    invoke-static/range {v4 .. v9}, La/b/c/a/a/i;->a(Landroid/content/res/TypedArray;Lorg/xmlpull/v1/XmlPullParser;Landroid/content/res/Resources$Theme;Ljava/lang/String;II)La/b/c/a/a/b;

    move-result-object v3

    iput-object v3, p0, La/b/b/a/k$b;->g:La/b/c/a/a/b;

    .line 1910
    const/16 v3, 0xc

    iget v4, p0, La/b/b/a/k$b;->j:F

    const-string v5, "fillAlpha"

    invoke-static {p1, p2, v5, v3, v4}, La/b/c/a/a/i;->a(Landroid/content/res/TypedArray;Lorg/xmlpull/v1/XmlPullParser;Ljava/lang/String;IF)F

    move-result v3

    iput v3, p0, La/b/b/a/k$b;->j:F

    .line 1912
    const/16 v3, 0x8

    const/4 v4, -0x1

    const-string v5, "strokeLineCap"

    invoke-static {p1, p2, v5, v3, v4}, La/b/c/a/a/i;->b(Landroid/content/res/TypedArray;Lorg/xmlpull/v1/XmlPullParser;Ljava/lang/String;II)I

    move-result v3

    .line 1914
    .local v3, "lineCap":I
    iget-object v5, p0, La/b/b/a/k$b;->n:Landroid/graphics/Paint$Cap;

    invoke-direct {p0, v3, v5}, La/b/b/a/k$b;->a(ILandroid/graphics/Paint$Cap;)Landroid/graphics/Paint$Cap;

    move-result-object v5

    iput-object v5, p0, La/b/b/a/k$b;->n:Landroid/graphics/Paint$Cap;

    .line 1915
    const/16 v5, 0x9

    const-string v6, "strokeLineJoin"

    invoke-static {p1, p2, v6, v5, v4}, La/b/c/a/a/i;->b(Landroid/content/res/TypedArray;Lorg/xmlpull/v1/XmlPullParser;Ljava/lang/String;II)I

    move-result v4

    .line 1917
    .local v4, "lineJoin":I
    iget-object v5, p0, La/b/b/a/k$b;->o:Landroid/graphics/Paint$Join;

    invoke-direct {p0, v4, v5}, La/b/b/a/k$b;->a(ILandroid/graphics/Paint$Join;)Landroid/graphics/Paint$Join;

    move-result-object v5

    iput-object v5, p0, La/b/b/a/k$b;->o:Landroid/graphics/Paint$Join;

    .line 1918
    const/16 v5, 0xa

    iget v6, p0, La/b/b/a/k$b;->p:F

    const-string v7, "strokeMiterLimit"

    invoke-static {p1, p2, v7, v5, v6}, La/b/c/a/a/i;->a(Landroid/content/res/TypedArray;Lorg/xmlpull/v1/XmlPullParser;Ljava/lang/String;IF)F

    move-result v5

    iput v5, p0, La/b/b/a/k$b;->p:F

    .line 1921
    const/4 v10, 0x3

    const/4 v11, 0x0

    const-string v9, "strokeColor"

    move-object v6, p1

    move-object v7, p2

    move-object v8, p3

    invoke-static/range {v6 .. v11}, La/b/c/a/a/i;->a(Landroid/content/res/TypedArray;Lorg/xmlpull/v1/XmlPullParser;Landroid/content/res/Resources$Theme;Ljava/lang/String;II)La/b/c/a/a/b;

    move-result-object v5

    iput-object v5, p0, La/b/b/a/k$b;->e:La/b/c/a/a/b;

    .line 1923
    const/16 v5, 0xb

    iget v6, p0, La/b/b/a/k$b;->h:F

    const-string v7, "strokeAlpha"

    invoke-static {p1, p2, v7, v5, v6}, La/b/c/a/a/i;->a(Landroid/content/res/TypedArray;Lorg/xmlpull/v1/XmlPullParser;Ljava/lang/String;IF)F

    move-result v5

    iput v5, p0, La/b/b/a/k$b;->h:F

    .line 1925
    const/4 v5, 0x4

    iget v6, p0, La/b/b/a/k$b;->f:F

    const-string v7, "strokeWidth"

    invoke-static {p1, p2, v7, v5, v6}, La/b/c/a/a/i;->a(Landroid/content/res/TypedArray;Lorg/xmlpull/v1/XmlPullParser;Ljava/lang/String;IF)F

    move-result v5

    iput v5, p0, La/b/b/a/k$b;->f:F

    .line 1927
    const/4 v5, 0x6

    iget v6, p0, La/b/b/a/k$b;->l:F

    const-string v7, "trimPathEnd"

    invoke-static {p1, p2, v7, v5, v6}, La/b/c/a/a/i;->a(Landroid/content/res/TypedArray;Lorg/xmlpull/v1/XmlPullParser;Ljava/lang/String;IF)F

    move-result v5

    iput v5, p0, La/b/b/a/k$b;->l:F

    .line 1929
    const/4 v5, 0x7

    iget v6, p0, La/b/b/a/k$b;->m:F

    const-string v7, "trimPathOffset"

    invoke-static {p1, p2, v7, v5, v6}, La/b/c/a/a/i;->a(Landroid/content/res/TypedArray;Lorg/xmlpull/v1/XmlPullParser;Ljava/lang/String;IF)F

    move-result v5

    iput v5, p0, La/b/b/a/k$b;->m:F

    .line 1932
    const/4 v5, 0x5

    iget v6, p0, La/b/b/a/k$b;->k:F

    const-string v7, "trimPathStart"

    invoke-static {p1, p2, v7, v5, v6}, La/b/c/a/a/i;->a(Landroid/content/res/TypedArray;Lorg/xmlpull/v1/XmlPullParser;Ljava/lang/String;IF)F

    move-result v5

    iput v5, p0, La/b/b/a/k$b;->k:F

    .line 1935
    const/16 v5, 0xd

    iget v6, p0, La/b/b/a/k$b;->i:I

    const-string v7, "fillType"

    invoke-static {p1, p2, v7, v5, v6}, La/b/c/a/a/i;->b(Landroid/content/res/TypedArray;Lorg/xmlpull/v1/XmlPullParser;Ljava/lang/String;II)I

    move-result v5

    iput v5, p0, La/b/b/a/k$b;->i:I

    .line 1938
    return-void
.end method


# virtual methods
.method public a(Landroid/content/res/Resources;Landroid/util/AttributeSet;Landroid/content/res/Resources$Theme;Lorg/xmlpull/v1/XmlPullParser;)V
    .locals 1
    .param p1, "r"    # Landroid/content/res/Resources;
    .param p2, "attrs"    # Landroid/util/AttributeSet;
    .param p3, "theme"    # Landroid/content/res/Resources$Theme;
    .param p4, "parser"    # Lorg/xmlpull/v1/XmlPullParser;

    .line 1872
    sget-object v0, La/b/b/a/a;->c:[I

    invoke-static {p1, p3, p2, v0}, La/b/c/a/a/i;->a(Landroid/content/res/Resources;Landroid/content/res/Resources$Theme;Landroid/util/AttributeSet;[I)Landroid/content/res/TypedArray;

    move-result-object v0

    .line 1874
    .local v0, "a":Landroid/content/res/TypedArray;
    invoke-direct {p0, v0, p4, p3}, La/b/b/a/k$b;->a(Landroid/content/res/TypedArray;Lorg/xmlpull/v1/XmlPullParser;Landroid/content/res/Resources$Theme;)V

    .line 1875
    invoke-virtual {v0}, Landroid/content/res/TypedArray;->recycle()V

    .line 1876
    return-void
.end method

.method public a()Z
    .locals 1

    .line 1942
    iget-object v0, p0, La/b/b/a/k$b;->g:La/b/c/a/a/b;

    invoke-virtual {v0}, La/b/c/a/a/b;->d()Z

    move-result v0

    if-nez v0, :cond_1

    iget-object v0, p0, La/b/b/a/k$b;->e:La/b/c/a/a/b;

    invoke-virtual {v0}, La/b/c/a/a/b;->d()Z

    move-result v0

    if-eqz v0, :cond_0

    goto :goto_0

    :cond_0
    const/4 v0, 0x0

    goto :goto_1

    :cond_1
    :goto_0
    const/4 v0, 0x1

    :goto_1
    return v0
.end method

.method public a([I)Z
    .locals 2
    .param p1, "stateSet"    # [I

    .line 1947
    iget-object v0, p0, La/b/b/a/k$b;->g:La/b/c/a/a/b;

    invoke-virtual {v0, p1}, La/b/c/a/a/b;->a([I)Z

    move-result v0

    .line 1948
    .local v0, "changed":Z
    iget-object v1, p0, La/b/b/a/k$b;->e:La/b/c/a/a/b;

    invoke-virtual {v1, p1}, La/b/c/a/a/b;->a([I)Z

    move-result v1

    or-int/2addr v0, v1

    .line 1949
    return v0
.end method

.method getFillAlpha()F
    .locals 1

    .line 2010
    iget v0, p0, La/b/b/a/k$b;->j:F

    return v0
.end method

.method getFillColor()I
    .locals 1

    .line 2000
    iget-object v0, p0, La/b/b/a/k$b;->g:La/b/c/a/a/b;

    invoke-virtual {v0}, La/b/c/a/a/b;->a()I

    move-result v0

    return v0
.end method

.method getStrokeAlpha()F
    .locals 1

    .line 1989
    iget v0, p0, La/b/b/a/k$b;->h:F

    return v0
.end method

.method getStrokeColor()I
    .locals 1

    .line 1969
    iget-object v0, p0, La/b/b/a/k$b;->e:La/b/c/a/a/b;

    invoke-virtual {v0}, La/b/c/a/a/b;->a()I

    move-result v0

    return v0
.end method

.method getStrokeWidth()F
    .locals 1

    .line 1979
    iget v0, p0, La/b/b/a/k$b;->f:F

    return v0
.end method

.method getTrimPathEnd()F
    .locals 1

    .line 2030
    iget v0, p0, La/b/b/a/k$b;->l:F

    return v0
.end method

.method getTrimPathOffset()F
    .locals 1

    .line 2040
    iget v0, p0, La/b/b/a/k$b;->m:F

    return v0
.end method

.method getTrimPathStart()F
    .locals 1

    .line 2020
    iget v0, p0, La/b/b/a/k$b;->k:F

    return v0
.end method

.method setFillAlpha(F)V
    .locals 0
    .param p1, "fillAlpha"    # F

    .line 2015
    iput p1, p0, La/b/b/a/k$b;->j:F

    .line 2016
    return-void
.end method

.method setFillColor(I)V
    .locals 1
    .param p1, "fillColor"    # I

    .line 2005
    iget-object v0, p0, La/b/b/a/k$b;->g:La/b/c/a/a/b;

    invoke-virtual {v0, p1}, La/b/c/a/a/b;->b(I)V

    .line 2006
    return-void
.end method

.method setStrokeAlpha(F)V
    .locals 0
    .param p1, "strokeAlpha"    # F

    .line 1994
    iput p1, p0, La/b/b/a/k$b;->h:F

    .line 1995
    return-void
.end method

.method setStrokeColor(I)V
    .locals 1
    .param p1, "strokeColor"    # I

    .line 1974
    iget-object v0, p0, La/b/b/a/k$b;->e:La/b/c/a/a/b;

    invoke-virtual {v0, p1}, La/b/c/a/a/b;->b(I)V

    .line 1975
    return-void
.end method

.method setStrokeWidth(F)V
    .locals 0
    .param p1, "strokeWidth"    # F

    .line 1984
    iput p1, p0, La/b/b/a/k$b;->f:F

    .line 1985
    return-void
.end method

.method setTrimPathEnd(F)V
    .locals 0
    .param p1, "trimPathEnd"    # F

    .line 2035
    iput p1, p0, La/b/b/a/k$b;->l:F

    .line 2036
    return-void
.end method

.method setTrimPathOffset(F)V
    .locals 0
    .param p1, "trimPathOffset"    # F

    .line 2045
    iput p1, p0, La/b/b/a/k$b;->m:F

    .line 2046
    return-void
.end method

.method setTrimPathStart(F)V
    .locals 0
    .param p1, "trimPathStart"    # F

    .line 2025
    iput p1, p0, La/b/b/a/k$b;->k:F

    .line 2026
    return-void
.end method
