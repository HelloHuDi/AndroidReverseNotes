.class Landroid/support/v7/widget/oa;
.super Ljava/lang/Object;
.source ""


# static fields
.field private static final a:Ljava/lang/ThreadLocal;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/lang/ThreadLocal<",
            "Landroid/util/TypedValue;",
            ">;"
        }
    .end annotation
.end field

.field static final b:[I

.field static final c:[I

.field static final d:[I

.field static final e:[I

.field static final f:[I

.field static final g:[I

.field static final h:[I

.field static final i:[I

.field private static final j:[I


# direct methods
.method static constructor <clinit>()V
    .locals 4

    .line 28
    new-instance v0, Ljava/lang/ThreadLocal;

    invoke-direct {v0}, Ljava/lang/ThreadLocal;-><init>()V

    sput-object v0, Landroid/support/v7/widget/oa;->a:Ljava/lang/ThreadLocal;

    .line 30
    const/4 v0, 0x1

    new-array v1, v0, [I

    const/4 v2, 0x0

    const v3, -0x101009e

    aput v3, v1, v2

    sput-object v1, Landroid/support/v7/widget/oa;->b:[I

    .line 31
    new-array v1, v0, [I

    const v3, 0x101009c

    aput v3, v1, v2

    sput-object v1, Landroid/support/v7/widget/oa;->c:[I

    .line 32
    new-array v1, v0, [I

    const v3, 0x10102fe

    aput v3, v1, v2

    sput-object v1, Landroid/support/v7/widget/oa;->d:[I

    .line 33
    new-array v1, v0, [I

    const v3, 0x10100a7

    aput v3, v1, v2

    sput-object v1, Landroid/support/v7/widget/oa;->e:[I

    .line 34
    new-array v1, v0, [I

    const v3, 0x10100a0

    aput v3, v1, v2

    sput-object v1, Landroid/support/v7/widget/oa;->f:[I

    .line 35
    new-array v1, v0, [I

    const v3, 0x10100a1

    aput v3, v1, v2

    sput-object v1, Landroid/support/v7/widget/oa;->g:[I

    .line 36
    const/4 v1, 0x2

    new-array v1, v1, [I

    fill-array-data v1, :array_0

    sput-object v1, Landroid/support/v7/widget/oa;->h:[I

    .line 38
    new-array v1, v2, [I

    sput-object v1, Landroid/support/v7/widget/oa;->i:[I

    .line 40
    new-array v0, v0, [I

    sput-object v0, Landroid/support/v7/widget/oa;->j:[I

    return-void

    :array_0
    .array-data 4
        -0x10100a7
        -0x101009c
    .end array-data
.end method

.method public static a(Landroid/content/Context;I)I
    .locals 5
    .param p0, "context"    # Landroid/content/Context;
    .param p1, "attr"    # I

    .line 83
    invoke-static {p0, p1}, Landroid/support/v7/widget/oa;->c(Landroid/content/Context;I)Landroid/content/res/ColorStateList;

    move-result-object v0

    .line 84
    .local v0, "csl":Landroid/content/res/ColorStateList;
    if-eqz v0, :cond_0

    invoke-virtual {v0}, Landroid/content/res/ColorStateList;->isStateful()Z

    move-result v1

    if-eqz v1, :cond_0

    .line 86
    sget-object v1, Landroid/support/v7/widget/oa;->b:[I

    invoke-virtual {v0}, Landroid/content/res/ColorStateList;->getDefaultColor()I

    move-result v2

    invoke-virtual {v0, v1, v2}, Landroid/content/res/ColorStateList;->getColorForState([II)I

    move-result v1

    return v1

    .line 90
    :cond_0
    invoke-static {}, Landroid/support/v7/widget/oa;->a()Landroid/util/TypedValue;

    move-result-object v1

    .line 92
    .local v1, "tv":Landroid/util/TypedValue;
    invoke-virtual {p0}, Landroid/content/Context;->getTheme()Landroid/content/res/Resources$Theme;

    move-result-object v2

    const v3, 0x1010033

    const/4 v4, 0x1

    invoke-virtual {v2, v3, v1, v4}, Landroid/content/res/Resources$Theme;->resolveAttribute(ILandroid/util/TypedValue;Z)Z

    .line 93
    invoke-virtual {v1}, Landroid/util/TypedValue;->getFloat()F

    move-result v2

    .line 95
    .local v2, "disabledAlpha":F
    invoke-static {p0, p1, v2}, Landroid/support/v7/widget/oa;->a(Landroid/content/Context;IF)I

    move-result v3

    return v3
.end method

.method static a(Landroid/content/Context;IF)I
    .locals 3
    .param p0, "context"    # Landroid/content/Context;
    .param p1, "attr"    # I
    .param p2, "alpha"    # F

    .line 109
    invoke-static {p0, p1}, Landroid/support/v7/widget/oa;->b(Landroid/content/Context;I)I

    move-result v0

    .line 110
    .local v0, "color":I
    invoke-static {v0}, Landroid/graphics/Color;->alpha(I)I

    move-result v1

    .line 111
    .local v1, "originalAlpha":I
    int-to-float v2, v1

    mul-float v2, v2, p2

    invoke-static {v2}, Ljava/lang/Math;->round(F)I

    move-result v2

    invoke-static {v0, v2}, La/b/c/b/a;->b(II)I

    move-result v2

    return v2
.end method

.method private static a()Landroid/util/TypedValue;
    .locals 2

    .line 100
    sget-object v0, Landroid/support/v7/widget/oa;->a:Ljava/lang/ThreadLocal;

    invoke-virtual {v0}, Ljava/lang/ThreadLocal;->get()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Landroid/util/TypedValue;

    .line 101
    .local v0, "typedValue":Landroid/util/TypedValue;
    if-nez v0, :cond_0

    .line 102
    new-instance v1, Landroid/util/TypedValue;

    invoke-direct {v1}, Landroid/util/TypedValue;-><init>()V

    move-object v0, v1

    .line 103
    sget-object v1, Landroid/support/v7/widget/oa;->a:Ljava/lang/ThreadLocal;

    invoke-virtual {v1, v0}, Ljava/lang/ThreadLocal;->set(Ljava/lang/Object;)V

    .line 105
    :cond_0
    return-object v0
.end method

.method public static b(Landroid/content/Context;I)I
    .locals 3
    .param p0, "context"    # Landroid/content/Context;
    .param p1, "attr"    # I

    .line 63
    sget-object v0, Landroid/support/v7/widget/oa;->j:[I

    const/4 v1, 0x0

    aput p1, v0, v1

    .line 64
    const/4 v2, 0x0

    invoke-static {p0, v2, v0}, Landroid/support/v7/widget/ta;->a(Landroid/content/Context;Landroid/util/AttributeSet;[I)Landroid/support/v7/widget/ta;

    move-result-object v0

    .line 66
    .local v0, "a":Landroid/support/v7/widget/ta;
    :try_start_0
    invoke-virtual {v0, v1, v1}, Landroid/support/v7/widget/ta;->a(II)I

    move-result v1
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    .line 68
    invoke-virtual {v0}, Landroid/support/v7/widget/ta;->a()V

    return v1

    :catchall_0
    move-exception v1

    invoke-virtual {v0}, Landroid/support/v7/widget/ta;->a()V

    throw v1
.end method

.method public static c(Landroid/content/Context;I)Landroid/content/res/ColorStateList;
    .locals 3
    .param p0, "context"    # Landroid/content/Context;
    .param p1, "attr"    # I

    .line 73
    sget-object v0, Landroid/support/v7/widget/oa;->j:[I

    const/4 v1, 0x0

    aput p1, v0, v1

    .line 74
    const/4 v2, 0x0

    invoke-static {p0, v2, v0}, Landroid/support/v7/widget/ta;->a(Landroid/content/Context;Landroid/util/AttributeSet;[I)Landroid/support/v7/widget/ta;

    move-result-object v0

    .line 76
    .local v0, "a":Landroid/support/v7/widget/ta;
    :try_start_0
    invoke-virtual {v0, v1}, Landroid/support/v7/widget/ta;->a(I)Landroid/content/res/ColorStateList;

    move-result-object v1
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    .line 78
    invoke-virtual {v0}, Landroid/support/v7/widget/ta;->a()V

    return-object v1

    :catchall_0
    move-exception v1

    invoke-virtual {v0}, Landroid/support/v7/widget/ta;->a()V

    throw v1
.end method
