.class public La/b/c/b/c;
.super Ljava/lang/Object;
.source ""


# static fields
.field private static final a:La/b/c/b/j;

.field private static final b:La/b/c/f/i;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "La/b/c/f/i<",
            "Ljava/lang/String;",
            "Landroid/graphics/Typeface;",
            ">;"
        }
    .end annotation
.end field


# direct methods
.method static constructor <clinit>()V
    .locals 2

    .line 49
    sget v0, Landroid/os/Build$VERSION;->SDK_INT:I

    const/16 v1, 0x1c

    if-lt v0, v1, :cond_0

    .line 50
    new-instance v0, La/b/c/b/g;

    invoke-direct {v0}, La/b/c/b/g;-><init>()V

    sput-object v0, La/b/c/b/c;->a:La/b/c/b/j;

    goto :goto_0

    .line 51
    :cond_0
    const/16 v1, 0x1a

    if-lt v0, v1, :cond_1

    .line 52
    new-instance v0, La/b/c/b/f;

    invoke-direct {v0}, La/b/c/b/f;-><init>()V

    sput-object v0, La/b/c/b/c;->a:La/b/c/b/j;

    goto :goto_0

    .line 53
    :cond_1
    const/16 v1, 0x18

    if-lt v0, v1, :cond_2

    .line 54
    invoke-static {}, La/b/c/b/e;->a()Z

    move-result v0

    if-eqz v0, :cond_2

    .line 55
    new-instance v0, La/b/c/b/e;

    invoke-direct {v0}, La/b/c/b/e;-><init>()V

    sput-object v0, La/b/c/b/c;->a:La/b/c/b/j;

    goto :goto_0

    .line 56
    :cond_2
    sget v0, Landroid/os/Build$VERSION;->SDK_INT:I

    const/16 v1, 0x15

    if-lt v0, v1, :cond_3

    .line 57
    new-instance v0, La/b/c/b/d;

    invoke-direct {v0}, La/b/c/b/d;-><init>()V

    sput-object v0, La/b/c/b/c;->a:La/b/c/b/j;

    goto :goto_0

    .line 59
    :cond_3
    new-instance v0, La/b/c/b/j;

    invoke-direct {v0}, La/b/c/b/j;-><init>()V

    sput-object v0, La/b/c/b/c;->a:La/b/c/b/j;

    .line 66
    :goto_0
    new-instance v0, La/b/c/f/i;

    const/16 v1, 0x10

    invoke-direct {v0, v1}, La/b/c/f/i;-><init>(I)V

    sput-object v0, La/b/c/b/c;->b:La/b/c/f/i;

    return-void
.end method

.method public static a(Landroid/content/Context;La/b/c/a/a/c$a;Landroid/content/res/Resources;IILa/b/c/a/a/h$a;Landroid/os/Handler;Z)Landroid/graphics/Typeface;
    .locals 11
    .param p0, "context"    # Landroid/content/Context;
    .param p1, "entry"    # La/b/c/a/a/c$a;
    .param p2, "resources"    # Landroid/content/res/Resources;
    .param p3, "id"    # I
    .param p4, "style"    # I
    .param p5, "fontCallback"    # La/b/c/a/a/h$a;
    .param p6, "handler"    # Landroid/os/Handler;
    .param p7, "isRequestFromLayoutInflator"    # Z

    .line 104
    move-object v0, p1

    move-object/from16 v8, p5

    move-object/from16 v9, p6

    instance-of v1, v0, La/b/c/a/a/c$d;

    if-eqz v1, :cond_3

    .line 105
    move-object v10, v0

    check-cast v10, La/b/c/a/a/c$d;

    .line 106
    .local v10, "providerEntry":La/b/c/a/a/c$d;
    const/4 v1, 0x1

    const/4 v2, 0x0

    if-eqz p7, :cond_0

    .line 107
    invoke-virtual {v10}, La/b/c/a/a/c$d;->a()I

    move-result v3

    if-nez v3, :cond_1

    goto :goto_0

    :cond_0
    if-nez v8, :cond_1

    :goto_0
    const/4 v5, 0x1

    goto :goto_1

    :cond_1
    const/4 v5, 0x0

    .line 110
    .local v5, "isBlocking":Z
    :goto_1
    if-eqz p7, :cond_2

    invoke-virtual {v10}, La/b/c/a/a/c$d;->c()I

    move-result v1

    move v6, v1

    goto :goto_2

    :cond_2
    const/4 v1, -0x1

    const/4 v6, -0x1

    .line 112
    .local v6, "timeout":I
    :goto_2
    invoke-virtual {v10}, La/b/c/a/a/c$d;->b()La/b/c/d/a;

    move-result-object v2

    move-object v1, p0

    move-object/from16 v3, p5

    move-object/from16 v4, p6

    move v7, p4

    invoke-static/range {v1 .. v7}, La/b/c/d/f;->a(Landroid/content/Context;La/b/c/d/a;La/b/c/a/a/h$a;Landroid/os/Handler;ZII)Landroid/graphics/Typeface;

    move-result-object v1

    .line 114
    .end local v5    # "isBlocking":Z
    .end local v6    # "timeout":I
    .end local v10    # "providerEntry":La/b/c/a/a/c$d;
    .local v1, "typeface":Landroid/graphics/Typeface;
    move-object v3, p0

    move-object v4, p2

    move v5, p4

    goto :goto_3

    .line 115
    .end local v1    # "typeface":Landroid/graphics/Typeface;
    :cond_3
    sget-object v1, La/b/c/b/c;->a:La/b/c/b/j;

    move-object v2, v0

    check-cast v2, La/b/c/a/a/c$b;

    move-object v3, p0

    move-object v4, p2

    move v5, p4

    invoke-virtual {v1, p0, v2, p2, p4}, La/b/c/b/j;->a(Landroid/content/Context;La/b/c/a/a/c$b;Landroid/content/res/Resources;I)Landroid/graphics/Typeface;

    move-result-object v1

    .line 117
    .restart local v1    # "typeface":Landroid/graphics/Typeface;
    if-eqz v8, :cond_5

    .line 118
    if-eqz v1, :cond_4

    .line 119
    invoke-virtual {v8, v1, v9}, La/b/c/a/a/h$a;->a(Landroid/graphics/Typeface;Landroid/os/Handler;)V

    goto :goto_3

    .line 121
    :cond_4
    const/4 v2, -0x3

    invoke-virtual {v8, v2, v9}, La/b/c/a/a/h$a;->a(ILandroid/os/Handler;)V

    .line 127
    :cond_5
    :goto_3
    if-eqz v1, :cond_6

    .line 128
    sget-object v2, La/b/c/b/c;->b:La/b/c/f/i;

    invoke-static {p2, p3, p4}, La/b/c/b/c;->b(Landroid/content/res/Resources;II)Ljava/lang/String;

    move-result-object v6

    invoke-virtual {v2, v6, v1}, La/b/c/f/i;->a(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 130
    :cond_6
    return-object v1
.end method

.method public static a(Landroid/content/Context;Landroid/content/res/Resources;ILjava/lang/String;I)Landroid/graphics/Typeface;
    .locals 6
    .param p0, "context"    # Landroid/content/Context;
    .param p1, "resources"    # Landroid/content/res/Resources;
    .param p2, "id"    # I
    .param p3, "path"    # Ljava/lang/String;
    .param p4, "style"    # I

    .line 140
    sget-object v0, La/b/c/b/c;->a:La/b/c/b/j;

    move-object v1, p0

    move-object v2, p1

    move v3, p2

    move-object v4, p3

    move v5, p4

    invoke-virtual/range {v0 .. v5}, La/b/c/b/j;->a(Landroid/content/Context;Landroid/content/res/Resources;ILjava/lang/String;I)Landroid/graphics/Typeface;

    move-result-object v0

    .line 142
    .local v0, "typeface":Landroid/graphics/Typeface;
    if-eqz v0, :cond_0

    .line 143
    invoke-static {p1, p2, p4}, La/b/c/b/c;->b(Landroid/content/res/Resources;II)Ljava/lang/String;

    move-result-object v1

    .line 144
    .local v1, "resourceUid":Ljava/lang/String;
    sget-object v2, La/b/c/b/c;->b:La/b/c/f/i;

    invoke-virtual {v2, v1, v0}, La/b/c/f/i;->a(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 146
    .end local v1    # "resourceUid":Ljava/lang/String;
    :cond_0
    return-object v0
.end method

.method public static a(Landroid/content/Context;Landroid/os/CancellationSignal;[La/b/c/d/f$b;I)Landroid/graphics/Typeface;
    .locals 1
    .param p0, "context"    # Landroid/content/Context;
    .param p1, "cancellationSignal"    # Landroid/os/CancellationSignal;
    .param p2, "fonts"    # [La/b/c/d/f$b;
    .param p3, "style"    # I

    .line 155
    sget-object v0, La/b/c/b/c;->a:La/b/c/b/j;

    invoke-virtual {v0, p0, p1, p2, p3}, La/b/c/b/j;->a(Landroid/content/Context;Landroid/os/CancellationSignal;[La/b/c/d/f$b;I)Landroid/graphics/Typeface;

    move-result-object v0

    return-object v0
.end method

.method public static a(Landroid/content/res/Resources;II)Landroid/graphics/Typeface;
    .locals 2
    .param p0, "resources"    # Landroid/content/res/Resources;
    .param p1, "id"    # I
    .param p2, "style"    # I

    .line 77
    sget-object v0, La/b/c/b/c;->b:La/b/c/f/i;

    invoke-static {p0, p1, p2}, La/b/c/b/c;->b(Landroid/content/res/Resources;II)Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, La/b/c/f/i;->b(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Landroid/graphics/Typeface;

    return-object v0
.end method

.method private static b(Landroid/content/res/Resources;II)Ljava/lang/String;
    .locals 2
    .param p0, "resources"    # Landroid/content/res/Resources;
    .param p1, "id"    # I
    .param p2, "style"    # I

    .line 89
    new-instance v0, Ljava/lang/StringBuilder;

    invoke-direct {v0}, Ljava/lang/StringBuilder;-><init>()V

    invoke-virtual {p0, p1}, Landroid/content/res/Resources;->getResourcePackageName(I)Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    const-string v1, "-"

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    invoke-virtual {v0, p1}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    invoke-virtual {v0, p2}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method
