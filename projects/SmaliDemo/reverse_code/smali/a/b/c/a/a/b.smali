.class public final La/b/c/a/a/b;
.super Ljava/lang/Object;
.source ""


# instance fields
.field private final a:Landroid/graphics/Shader;

.field private final b:Landroid/content/res/ColorStateList;

.field private c:I


# direct methods
.method private constructor <init>(Landroid/graphics/Shader;Landroid/content/res/ColorStateList;I)V
    .locals 0
    .param p1, "shader"    # Landroid/graphics/Shader;
    .param p2, "colorStateList"    # Landroid/content/res/ColorStateList;
    .param p3, "color"    # I

    .line 61
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 62
    iput-object p1, p0, La/b/c/a/a/b;->a:Landroid/graphics/Shader;

    .line 63
    iput-object p2, p0, La/b/c/a/a/b;->b:Landroid/content/res/ColorStateList;

    .line 64
    iput p3, p0, La/b/c/a/a/b;->c:I

    .line 65
    return-void
.end method

.method static a(I)La/b/c/a/a/b;
    .locals 2
    .param p0, "color"    # I

    .line 76
    new-instance v0, La/b/c/a/a/b;

    const/4 v1, 0x0

    invoke-direct {v0, v1, v1, p0}, La/b/c/a/a/b;-><init>(Landroid/graphics/Shader;Landroid/content/res/ColorStateList;I)V

    return-object v0
.end method

.method static a(Landroid/content/res/ColorStateList;)La/b/c/a/a/b;
    .locals 3
    .param p0, "colorStateList"    # Landroid/content/res/ColorStateList;

    .line 72
    new-instance v0, La/b/c/a/a/b;

    invoke-virtual {p0}, Landroid/content/res/ColorStateList;->getDefaultColor()I

    move-result v1

    const/4 v2, 0x0

    invoke-direct {v0, v2, p0, v1}, La/b/c/a/a/b;-><init>(Landroid/graphics/Shader;Landroid/content/res/ColorStateList;I)V

    return-object v0
.end method

.method public static a(Landroid/content/res/Resources;ILandroid/content/res/Resources$Theme;)La/b/c/a/a/b;
    .locals 3
    .param p0, "resources"    # Landroid/content/res/Resources;
    .param p1, "resId"    # I
    .param p2, "theme"    # Landroid/content/res/Resources$Theme;

    .line 140
    :try_start_0
    invoke-static {p0, p1, p2}, La/b/c/a/a/b;->b(Landroid/content/res/Resources;ILandroid/content/res/Resources$Theme;)La/b/c/a/a/b;

    move-result-object v0
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_0

    return-object v0

    .line 141
    :catch_0
    move-exception v0

    .line 142
    .local v0, "e":Ljava/lang/Exception;
    const-string v1, "ComplexColorCompat"

    const-string v2, "Failed to inflate ComplexColor."

    invoke-static {v1, v2, v0}, Landroid/util/Log;->e(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I

    .line 144
    .end local v0    # "e":Ljava/lang/Exception;
    const/4 v0, 0x0

    return-object v0
.end method

.method static a(Landroid/graphics/Shader;)La/b/c/a/a/b;
    .locals 3
    .param p0, "shader"    # Landroid/graphics/Shader;

    .line 68
    new-instance v0, La/b/c/a/a/b;

    const/4 v1, 0x0

    const/4 v2, 0x0

    invoke-direct {v0, p0, v1, v2}, La/b/c/a/a/b;-><init>(Landroid/graphics/Shader;Landroid/content/res/ColorStateList;I)V

    return-object v0
.end method

.method private static b(Landroid/content/res/Resources;ILandroid/content/res/Resources$Theme;)La/b/c/a/a/b;
    .locals 8
    .param p0, "resources"    # Landroid/content/res/Resources;
    .param p1, "resId"    # I
    .param p2, "theme"    # Landroid/content/res/Resources$Theme;

    .line 152
    invoke-virtual {p0, p1}, Landroid/content/res/Resources;->getXml(I)Landroid/content/res/XmlResourceParser;

    move-result-object v0

    .line 153
    .local v0, "parser":Lorg/xmlpull/v1/XmlPullParser;
    invoke-static {v0}, Landroid/util/Xml;->asAttributeSet(Lorg/xmlpull/v1/XmlPullParser;)Landroid/util/AttributeSet;

    move-result-object v1

    .line 155
    .local v1, "attrs":Landroid/util/AttributeSet;
    :goto_0
    invoke-interface {v0}, Lorg/xmlpull/v1/XmlPullParser;->next()I

    move-result v2

    move v3, v2

    .local v3, "type":I
    const/4 v4, 0x2

    const/4 v5, 0x1

    if-eq v2, v4, :cond_0

    if-eq v3, v5, :cond_0

    goto :goto_0

    .line 159
    :cond_0
    if-ne v3, v4, :cond_6

    .line 162
    invoke-interface {v0}, Lorg/xmlpull/v1/XmlPullParser;->getName()Ljava/lang/String;

    move-result-object v2

    .line 163
    .local v2, "name":Ljava/lang/String;
    const/4 v4, -0x1

    invoke-virtual {v2}, Ljava/lang/String;->hashCode()I

    move-result v6

    const v7, 0x557f730

    if-eq v6, v7, :cond_3

    const v7, 0x4705f3df

    if-eq v6, v7, :cond_2

    :cond_1
    goto :goto_1

    :cond_2
    const-string v6, "selector"

    invoke-virtual {v2, v6}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v6

    if-eqz v6, :cond_1

    const/4 v4, 0x0

    goto :goto_1

    :cond_3
    const-string v6, "gradient"

    invoke-virtual {v2, v6}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v6

    if-eqz v6, :cond_1

    const/4 v4, 0x1

    :goto_1
    if-eqz v4, :cond_5

    if-ne v4, v5, :cond_4

    .line 168
    invoke-static {p0, v0, v1, p2}, La/b/c/a/a/d;->a(Landroid/content/res/Resources;Lorg/xmlpull/v1/XmlPullParser;Landroid/util/AttributeSet;Landroid/content/res/Resources$Theme;)Landroid/graphics/Shader;

    move-result-object v4

    invoke-static {v4}, La/b/c/a/a/b;->a(Landroid/graphics/Shader;)La/b/c/a/a/b;

    move-result-object v4

    return-object v4

    .line 171
    :cond_4
    new-instance v4, Lorg/xmlpull/v1/XmlPullParserException;

    new-instance v5, Ljava/lang/StringBuilder;

    invoke-direct {v5}, Ljava/lang/StringBuilder;-><init>()V

    invoke-interface {v0}, Lorg/xmlpull/v1/XmlPullParser;->getPositionDescription()Ljava/lang/String;

    move-result-object v6

    invoke-virtual {v5, v6}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    const-string v6, ": unsupported complex color tag "

    invoke-virtual {v5, v6}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    invoke-virtual {v5, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    invoke-virtual {v5}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v5

    invoke-direct {v4, v5}, Lorg/xmlpull/v1/XmlPullParserException;-><init>(Ljava/lang/String;)V

    throw v4

    .line 165
    :cond_5
    invoke-static {p0, v0, v1, p2}, La/b/c/a/a/a;->a(Landroid/content/res/Resources;Lorg/xmlpull/v1/XmlPullParser;Landroid/util/AttributeSet;Landroid/content/res/Resources$Theme;)Landroid/content/res/ColorStateList;

    move-result-object v4

    invoke-static {v4}, La/b/c/a/a/b;->a(Landroid/content/res/ColorStateList;)La/b/c/a/a/b;

    move-result-object v4

    return-object v4

    .line 160
    .end local v2    # "name":Ljava/lang/String;
    :cond_6
    new-instance v2, Lorg/xmlpull/v1/XmlPullParserException;

    const-string v4, "No start tag found"

    invoke-direct {v2, v4}, Lorg/xmlpull/v1/XmlPullParserException;-><init>(Ljava/lang/String;)V

    goto :goto_3

    :goto_2
    throw v2

    :goto_3
    goto :goto_2
.end method


# virtual methods
.method public a()I
    .locals 1

    .line 86
    iget v0, p0, La/b/c/a/a/b;->c:I

    return v0
.end method

.method public a([I)Z
    .locals 3
    .param p1, "stateSet"    # [I

    .line 108
    const/4 v0, 0x0

    .line 109
    .local v0, "changed":Z
    invoke-virtual {p0}, La/b/c/a/a/b;->d()Z

    move-result v1

    if-eqz v1, :cond_0

    .line 110
    iget-object v1, p0, La/b/c/a/a/b;->b:Landroid/content/res/ColorStateList;

    .line 111
    invoke-virtual {v1}, Landroid/content/res/ColorStateList;->getDefaultColor()I

    move-result v2

    .line 110
    invoke-virtual {v1, p1, v2}, Landroid/content/res/ColorStateList;->getColorForState([II)I

    move-result v1

    .line 112
    .local v1, "colorForState":I
    iget v2, p0, La/b/c/a/a/b;->c:I

    if-eq v1, v2, :cond_0

    .line 113
    const/4 v0, 0x1

    .line 114
    iput v1, p0, La/b/c/a/a/b;->c:I

    .line 117
    .end local v1    # "colorForState":I
    :cond_0
    return v0
.end method

.method public b()Landroid/graphics/Shader;
    .locals 1

    .line 81
    iget-object v0, p0, La/b/c/a/a/b;->a:Landroid/graphics/Shader;

    return-object v0
.end method

.method public b(I)V
    .locals 0
    .param p1, "color"    # I

    .line 90
    iput p1, p0, La/b/c/a/a/b;->c:I

    .line 91
    return-void
.end method

.method public c()Z
    .locals 1

    .line 94
    iget-object v0, p0, La/b/c/a/a/b;->a:Landroid/graphics/Shader;

    if-eqz v0, :cond_0

    const/4 v0, 0x1

    goto :goto_0

    :cond_0
    const/4 v0, 0x0

    :goto_0
    return v0
.end method

.method public d()Z
    .locals 1

    .line 98
    iget-object v0, p0, La/b/c/a/a/b;->a:Landroid/graphics/Shader;

    if-nez v0, :cond_0

    iget-object v0, p0, La/b/c/a/a/b;->b:Landroid/content/res/ColorStateList;

    if-eqz v0, :cond_0

    invoke-virtual {v0}, Landroid/content/res/ColorStateList;->isStateful()Z

    move-result v0

    if-eqz v0, :cond_0

    const/4 v0, 0x1

    goto :goto_0

    :cond_0
    const/4 v0, 0x0

    :goto_0
    return v0
.end method

.method public e()Z
    .locals 1

    .line 124
    invoke-virtual {p0}, La/b/c/a/a/b;->c()Z

    move-result v0

    if-nez v0, :cond_1

    iget v0, p0, La/b/c/a/a/b;->c:I

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
