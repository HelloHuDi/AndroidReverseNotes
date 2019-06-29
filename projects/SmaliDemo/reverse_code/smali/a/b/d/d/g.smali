.class public La/b/d/d/g;
.super Landroid/view/MenuInflater;
.source ""


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        La/b/d/d/g$b;,
        La/b/d/d/g$a;
    }
.end annotation


# static fields
.field static final a:[Ljava/lang/Class;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "[",
            "Ljava/lang/Class<",
            "*>;"
        }
    .end annotation
.end field

.field static final b:[Ljava/lang/Class;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "[",
            "Ljava/lang/Class<",
            "*>;"
        }
    .end annotation
.end field


# instance fields
.field final c:[Ljava/lang/Object;

.field final d:[Ljava/lang/Object;

.field e:Landroid/content/Context;

.field private f:Ljava/lang/Object;


# direct methods
.method static constructor <clinit>()V
    .locals 3

    .line 82
    const/4 v0, 0x1

    new-array v0, v0, [Ljava/lang/Class;

    const-class v1, Landroid/content/Context;

    const/4 v2, 0x0

    aput-object v1, v0, v2

    sput-object v0, La/b/d/d/g;->a:[Ljava/lang/Class;

    .line 84
    sget-object v0, La/b/d/d/g;->a:[Ljava/lang/Class;

    sput-object v0, La/b/d/d/g;->b:[Ljava/lang/Class;

    return-void
.end method

.method public constructor <init>(Landroid/content/Context;)V
    .locals 2
    .param p1, "context"    # Landroid/content/Context;

    .line 100
    invoke-direct {p0, p1}, Landroid/view/MenuInflater;-><init>(Landroid/content/Context;)V

    .line 101
    iput-object p1, p0, La/b/d/d/g;->e:Landroid/content/Context;

    .line 102
    const/4 v0, 0x1

    new-array v0, v0, [Ljava/lang/Object;

    const/4 v1, 0x0

    aput-object p1, v0, v1

    iput-object v0, p0, La/b/d/d/g;->c:[Ljava/lang/Object;

    .line 103
    iget-object v0, p0, La/b/d/d/g;->c:[Ljava/lang/Object;

    iput-object v0, p0, La/b/d/d/g;->d:[Ljava/lang/Object;

    .line 104
    return-void
.end method

.method private a(Ljava/lang/Object;)Ljava/lang/Object;
    .locals 1
    .param p1, "owner"    # Ljava/lang/Object;

    .line 230
    instance-of v0, p1, Landroid/app/Activity;

    if-eqz v0, :cond_0

    .line 231
    return-object p1

    .line 233
    :cond_0
    instance-of v0, p1, Landroid/content/ContextWrapper;

    if-eqz v0, :cond_1

    .line 234
    move-object v0, p1

    check-cast v0, Landroid/content/ContextWrapper;

    invoke-virtual {v0}, Landroid/content/ContextWrapper;->getBaseContext()Landroid/content/Context;

    move-result-object v0

    invoke-direct {p0, v0}, La/b/d/d/g;->a(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v0

    return-object v0

    .line 236
    :cond_1
    return-object p1
.end method

.method private a(Lorg/xmlpull/v1/XmlPullParser;Landroid/util/AttributeSet;Landroid/view/Menu;)V
    .locals 12
    .param p1, "parser"    # Lorg/xmlpull/v1/XmlPullParser;
    .param p2, "attrs"    # Landroid/util/AttributeSet;
    .param p3, "menu"    # Landroid/view/Menu;

    .line 144
    new-instance v0, La/b/d/d/g$b;

    invoke-direct {v0, p0, p3}, La/b/d/d/g$b;-><init>(La/b/d/d/g;Landroid/view/Menu;)V

    .line 146
    .local v0, "menuState":La/b/d/d/g$b;
    invoke-interface {p1}, Lorg/xmlpull/v1/XmlPullParser;->getEventType()I

    move-result v1

    .line 148
    .local v1, "eventType":I
    const/4 v2, 0x0

    .line 149
    .local v2, "lookingForEndOfUnknownTag":Z
    const/4 v3, 0x0

    .line 153
    .local v3, "unknownTagName":Ljava/lang/String;
    :goto_0
    const/4 v4, 0x1

    const/4 v5, 0x2

    const-string v6, "menu"

    if-ne v1, v5, :cond_1

    .line 154
    invoke-interface {p1}, Lorg/xmlpull/v1/XmlPullParser;->getName()Ljava/lang/String;

    move-result-object v7

    .line 155
    .local v7, "tagName":Ljava/lang/String;
    invoke-virtual {v7, v6}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v8

    if-eqz v8, :cond_0

    .line 157
    invoke-interface {p1}, Lorg/xmlpull/v1/XmlPullParser;->next()I

    move-result v1

    .line 158
    goto :goto_1

    .line 161
    :cond_0
    new-instance v4, Ljava/lang/RuntimeException;

    new-instance v5, Ljava/lang/StringBuilder;

    invoke-direct {v5}, Ljava/lang/StringBuilder;-><init>()V

    const-string v6, "Expecting menu, got "

    invoke-virtual {v5, v6}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    invoke-virtual {v5, v7}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    invoke-virtual {v5}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v5

    invoke-direct {v4, v5}, Ljava/lang/RuntimeException;-><init>(Ljava/lang/String;)V

    throw v4

    .line 163
    .end local v7    # "tagName":Ljava/lang/String;
    :cond_1
    invoke-interface {p1}, Lorg/xmlpull/v1/XmlPullParser;->next()I

    move-result v1

    .line 164
    if-ne v1, v4, :cond_f

    .line 166
    :goto_1
    const/4 v7, 0x0

    .line 167
    .local v7, "reachedEndOfMenu":Z
    :goto_2
    if-nez v7, :cond_e

    .line 168
    if-eq v1, v4, :cond_d

    const-string v8, "item"

    const-string v9, "group"

    if-eq v1, v5, :cond_7

    const/4 v10, 0x3

    if-eq v1, v10, :cond_2

    goto/16 :goto_3

    .line 192
    :cond_2
    invoke-interface {p1}, Lorg/xmlpull/v1/XmlPullParser;->getName()Ljava/lang/String;

    move-result-object v10

    .line 193
    .local v10, "tagName":Ljava/lang/String;
    if-eqz v2, :cond_3

    invoke-virtual {v10, v3}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v11

    if-eqz v11, :cond_3

    .line 194
    const/4 v2, 0x0

    .line 195
    const/4 v3, 0x0

    goto :goto_3

    .line 196
    :cond_3
    invoke-virtual {v10, v9}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v9

    if-eqz v9, :cond_4

    .line 197
    invoke-virtual {v0}, La/b/d/d/g$b;->d()V

    goto :goto_3

    .line 198
    :cond_4
    invoke-virtual {v10, v8}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v8

    if-eqz v8, :cond_6

    .line 201
    invoke-virtual {v0}, La/b/d/d/g$b;->c()Z

    move-result v8

    if-nez v8, :cond_c

    .line 202
    iget-object v8, v0, La/b/d/d/g$b;->A:La/b/c/g/e;

    if-eqz v8, :cond_5

    .line 203
    invoke-virtual {v8}, La/b/c/g/e;->a()Z

    move-result v8

    if-eqz v8, :cond_5

    .line 204
    invoke-virtual {v0}, La/b/d/d/g$b;->b()Landroid/view/SubMenu;

    goto :goto_3

    .line 206
    :cond_5
    invoke-virtual {v0}, La/b/d/d/g$b;->a()V

    goto :goto_3

    .line 209
    :cond_6
    invoke-virtual {v10, v6}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v8

    if-eqz v8, :cond_c

    .line 210
    const/4 v7, 0x1

    goto :goto_3

    .line 170
    .end local v10    # "tagName":Ljava/lang/String;
    :cond_7
    if-eqz v2, :cond_8

    .line 171
    goto :goto_3

    .line 174
    :cond_8
    invoke-interface {p1}, Lorg/xmlpull/v1/XmlPullParser;->getName()Ljava/lang/String;

    move-result-object v10

    .line 175
    .restart local v10    # "tagName":Ljava/lang/String;
    invoke-virtual {v10, v9}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v9

    if-eqz v9, :cond_9

    .line 176
    invoke-virtual {v0, p2}, La/b/d/d/g$b;->a(Landroid/util/AttributeSet;)V

    goto :goto_3

    .line 177
    :cond_9
    invoke-virtual {v10, v8}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v8

    if-eqz v8, :cond_a

    .line 178
    invoke-virtual {v0, p2}, La/b/d/d/g$b;->b(Landroid/util/AttributeSet;)V

    goto :goto_3

    .line 179
    :cond_a
    invoke-virtual {v10, v6}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v8

    if-eqz v8, :cond_b

    .line 181
    invoke-virtual {v0}, La/b/d/d/g$b;->b()Landroid/view/SubMenu;

    move-result-object v8

    .line 184
    .local v8, "subMenu":Landroid/view/SubMenu;
    invoke-direct {p0, p1, p2, v8}, La/b/d/d/g;->a(Lorg/xmlpull/v1/XmlPullParser;Landroid/util/AttributeSet;Landroid/view/Menu;)V

    .line 185
    .end local v8    # "subMenu":Landroid/view/SubMenu;
    goto :goto_3

    .line 186
    :cond_b
    const/4 v2, 0x1

    .line 187
    move-object v3, v10

    .line 189
    nop

    .line 218
    .end local v10    # "tagName":Ljava/lang/String;
    :cond_c
    :goto_3
    invoke-interface {p1}, Lorg/xmlpull/v1/XmlPullParser;->next()I

    move-result v1

    goto :goto_2

    .line 215
    :cond_d
    new-instance v4, Ljava/lang/RuntimeException;

    const-string v5, "Unexpected end of document"

    invoke-direct {v4, v5}, Ljava/lang/RuntimeException;-><init>(Ljava/lang/String;)V

    throw v4

    .line 220
    :cond_e
    return-void

    .line 164
    .end local v7    # "reachedEndOfMenu":Z
    :cond_f
    goto/16 :goto_0
.end method


# virtual methods
.method a()Ljava/lang/Object;
    .locals 1

    .line 223
    iget-object v0, p0, La/b/d/d/g;->f:Ljava/lang/Object;

    if-nez v0, :cond_0

    .line 224
    iget-object v0, p0, La/b/d/d/g;->e:Landroid/content/Context;

    invoke-direct {p0, v0}, La/b/d/d/g;->a(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v0

    iput-object v0, p0, La/b/d/d/g;->f:Ljava/lang/Object;

    .line 226
    :cond_0
    iget-object v0, p0, La/b/d/d/g;->f:Ljava/lang/Object;

    return-object v0
.end method

.method public inflate(ILandroid/view/Menu;)V
    .locals 4
    .param p1, "menuRes"    # I
    .param p2, "menu"    # Landroid/view/Menu;

    .line 118
    const-string v0, "Error inflating menu XML"

    instance-of v1, p2, La/b/c/c/a/a;

    if-nez v1, :cond_0

    .line 119
    invoke-super {p0, p1, p2}, Landroid/view/MenuInflater;->inflate(ILandroid/view/Menu;)V

    .line 120
    return-void

    .line 123
    :cond_0
    const/4 v1, 0x0

    .line 125
    .local v1, "parser":Landroid/content/res/XmlResourceParser;
    :try_start_0
    iget-object v2, p0, La/b/d/d/g;->e:Landroid/content/Context;

    invoke-virtual {v2}, Landroid/content/Context;->getResources()Landroid/content/res/Resources;

    move-result-object v2

    invoke-virtual {v2, p1}, Landroid/content/res/Resources;->getLayout(I)Landroid/content/res/XmlResourceParser;

    move-result-object v2

    move-object v1, v2

    .line 126
    invoke-static {v1}, Landroid/util/Xml;->asAttributeSet(Lorg/xmlpull/v1/XmlPullParser;)Landroid/util/AttributeSet;

    move-result-object v2

    .line 128
    .local v2, "attrs":Landroid/util/AttributeSet;
    invoke-direct {p0, v1, v2, p2}, La/b/d/d/g;->a(Lorg/xmlpull/v1/XmlPullParser;Landroid/util/AttributeSet;Landroid/view/Menu;)V
    :try_end_0
    .catch Lorg/xmlpull/v1/XmlPullParserException; {:try_start_0 .. :try_end_0} :catch_1
    .catch Ljava/io/IOException; {:try_start_0 .. :try_end_0} :catch_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    .line 134
    .end local v2    # "attrs":Landroid/util/AttributeSet;
    if-eqz v1, :cond_1

    invoke-interface {v1}, Landroid/content/res/XmlResourceParser;->close()V

    .line 136
    :cond_1
    return-void

    .line 134
    :catchall_0
    move-exception v0

    goto :goto_0

    .line 131
    :catch_0
    move-exception v2

    .line 132
    .local v2, "e":Ljava/io/IOException;
    :try_start_1
    new-instance v3, Landroid/view/InflateException;

    invoke-direct {v3, v0, v2}, Landroid/view/InflateException;-><init>(Ljava/lang/String;Ljava/lang/Throwable;)V

    .end local v1    # "parser":Landroid/content/res/XmlResourceParser;
    .end local p1    # "menuRes":I
    .end local p2    # "menu":Landroid/view/Menu;
    throw v3

    .line 129
    .end local v2    # "e":Ljava/io/IOException;
    .restart local v1    # "parser":Landroid/content/res/XmlResourceParser;
    .restart local p1    # "menuRes":I
    .restart local p2    # "menu":Landroid/view/Menu;
    :catch_1
    move-exception v2

    .line 130
    .local v2, "e":Lorg/xmlpull/v1/XmlPullParserException;
    new-instance v3, Landroid/view/InflateException;

    invoke-direct {v3, v0, v2}, Landroid/view/InflateException;-><init>(Ljava/lang/String;Ljava/lang/Throwable;)V

    .end local v1    # "parser":Landroid/content/res/XmlResourceParser;
    .end local p1    # "menuRes":I
    .end local p2    # "menu":Landroid/view/Menu;
    throw v3
    :try_end_1
    .catchall {:try_start_1 .. :try_end_1} :catchall_0

    .line 134
    .end local v2    # "e":Lorg/xmlpull/v1/XmlPullParserException;
    .restart local v1    # "parser":Landroid/content/res/XmlResourceParser;
    .restart local p1    # "menuRes":I
    .restart local p2    # "menu":Landroid/view/Menu;
    :goto_0
    if-eqz v1, :cond_2

    invoke-interface {v1}, Landroid/content/res/XmlResourceParser;->close()V

    :cond_2
    throw v0
.end method
