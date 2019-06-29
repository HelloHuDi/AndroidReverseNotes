.class public Landroid/support/v7/widget/ta;
.super Ljava/lang/Object;
.source ""


# instance fields
.field private final a:Landroid/content/Context;

.field private final b:Landroid/content/res/TypedArray;

.field private c:Landroid/util/TypedValue;


# direct methods
.method private constructor <init>(Landroid/content/Context;Landroid/content/res/TypedArray;)V
    .locals 0
    .param p1, "context"    # Landroid/content/Context;
    .param p2, "array"    # Landroid/content/res/TypedArray;

    .line 67
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 68
    iput-object p1, p0, Landroid/support/v7/widget/ta;->a:Landroid/content/Context;

    .line 69
    iput-object p2, p0, Landroid/support/v7/widget/ta;->b:Landroid/content/res/TypedArray;

    .line 70
    return-void
.end method

.method public static a(Landroid/content/Context;I[I)Landroid/support/v7/widget/ta;
    .locals 2
    .param p0, "context"    # Landroid/content/Context;
    .param p1, "resid"    # I
    .param p2, "attrs"    # [I

    .line 64
    new-instance v0, Landroid/support/v7/widget/ta;

    invoke-virtual {p0, p1, p2}, Landroid/content/Context;->obtainStyledAttributes(I[I)Landroid/content/res/TypedArray;

    move-result-object v1

    invoke-direct {v0, p0, v1}, Landroid/support/v7/widget/ta;-><init>(Landroid/content/Context;Landroid/content/res/TypedArray;)V

    return-object v0
.end method

.method public static a(Landroid/content/Context;Landroid/util/AttributeSet;[I)Landroid/support/v7/widget/ta;
    .locals 2
    .param p0, "context"    # Landroid/content/Context;
    .param p1, "set"    # Landroid/util/AttributeSet;
    .param p2, "attrs"    # [I

    .line 54
    new-instance v0, Landroid/support/v7/widget/ta;

    invoke-virtual {p0, p1, p2}, Landroid/content/Context;->obtainStyledAttributes(Landroid/util/AttributeSet;[I)Landroid/content/res/TypedArray;

    move-result-object v1

    invoke-direct {v0, p0, v1}, Landroid/support/v7/widget/ta;-><init>(Landroid/content/Context;Landroid/content/res/TypedArray;)V

    return-object v0
.end method

.method public static a(Landroid/content/Context;Landroid/util/AttributeSet;[III)Landroid/support/v7/widget/ta;
    .locals 2
    .param p0, "context"    # Landroid/content/Context;
    .param p1, "set"    # Landroid/util/AttributeSet;
    .param p2, "attrs"    # [I
    .param p3, "defStyleAttr"    # I
    .param p4, "defStyleRes"    # I

    .line 59
    new-instance v0, Landroid/support/v7/widget/ta;

    .line 60
    invoke-virtual {p0, p1, p2, p3, p4}, Landroid/content/Context;->obtainStyledAttributes(Landroid/util/AttributeSet;[III)Landroid/content/res/TypedArray;

    move-result-object v1

    invoke-direct {v0, p0, v1}, Landroid/support/v7/widget/ta;-><init>(Landroid/content/Context;Landroid/content/res/TypedArray;)V

    return-object v0
.end method


# virtual methods
.method public a(IF)F
    .locals 1
    .param p1, "index"    # I
    .param p2, "defValue"    # F

    .line 159
    iget-object v0, p0, Landroid/support/v7/widget/ta;->b:Landroid/content/res/TypedArray;

    invoke-virtual {v0, p1, p2}, Landroid/content/res/TypedArray;->getFloat(IF)F

    move-result v0

    return v0
.end method

.method public a(II)I
    .locals 1
    .param p1, "index"    # I
    .param p2, "defValue"    # I

    .line 163
    iget-object v0, p0, Landroid/support/v7/widget/ta;->b:Landroid/content/res/TypedArray;

    invoke-virtual {v0, p1, p2}, Landroid/content/res/TypedArray;->getColor(II)I

    move-result v0

    return v0
.end method

.method public a(I)Landroid/content/res/ColorStateList;
    .locals 2
    .param p1, "index"    # I

    .line 167
    iget-object v0, p0, Landroid/support/v7/widget/ta;->b:Landroid/content/res/TypedArray;

    invoke-virtual {v0, p1}, Landroid/content/res/TypedArray;->hasValue(I)Z

    move-result v0

    if-eqz v0, :cond_0

    .line 168
    iget-object v0, p0, Landroid/support/v7/widget/ta;->b:Landroid/content/res/TypedArray;

    const/4 v1, 0x0

    invoke-virtual {v0, p1, v1}, Landroid/content/res/TypedArray;->getResourceId(II)I

    move-result v0

    .line 169
    .local v0, "resourceId":I
    if-eqz v0, :cond_0

    .line 170
    iget-object v1, p0, Landroid/support/v7/widget/ta;->a:Landroid/content/Context;

    .line 171
    invoke-static {v1, v0}, La/b/d/b/a/a;->a(Landroid/content/Context;I)Landroid/content/res/ColorStateList;

    move-result-object v1

    .line 172
    .local v1, "value":Landroid/content/res/ColorStateList;
    if-eqz v1, :cond_0

    .line 173
    return-object v1

    .line 177
    .end local v0    # "resourceId":I
    .end local v1    # "value":Landroid/content/res/ColorStateList;
    :cond_0
    iget-object v0, p0, Landroid/support/v7/widget/ta;->b:Landroid/content/res/TypedArray;

    invoke-virtual {v0, p1}, Landroid/content/res/TypedArray;->getColorStateList(I)Landroid/content/res/ColorStateList;

    move-result-object v0

    return-object v0
.end method

.method public a(IILa/b/c/a/a/h$a;)Landroid/graphics/Typeface;
    .locals 3
    .param p1, "index"    # I
    .param p2, "style"    # I
    .param p3, "fontCallback"    # La/b/c/a/a/h$a;

    .line 112
    iget-object v0, p0, Landroid/support/v7/widget/ta;->b:Landroid/content/res/TypedArray;

    const/4 v1, 0x0

    invoke-virtual {v0, p1, v1}, Landroid/content/res/TypedArray;->getResourceId(II)I

    move-result v0

    .line 113
    .local v0, "resourceId":I
    if-nez v0, :cond_0

    .line 114
    const/4 v1, 0x0

    return-object v1

    .line 116
    :cond_0
    iget-object v1, p0, Landroid/support/v7/widget/ta;->c:Landroid/util/TypedValue;

    if-nez v1, :cond_1

    .line 117
    new-instance v1, Landroid/util/TypedValue;

    invoke-direct {v1}, Landroid/util/TypedValue;-><init>()V

    iput-object v1, p0, Landroid/support/v7/widget/ta;->c:Landroid/util/TypedValue;

    .line 119
    :cond_1
    iget-object v1, p0, Landroid/support/v7/widget/ta;->a:Landroid/content/Context;

    iget-object v2, p0, Landroid/support/v7/widget/ta;->c:Landroid/util/TypedValue;

    invoke-static {v1, v0, v2, p2, p3}, La/b/c/a/a/h;->a(Landroid/content/Context;ILandroid/util/TypedValue;ILa/b/c/a/a/h$a;)Landroid/graphics/Typeface;

    move-result-object v1

    return-object v1
.end method

.method public a()V
    .locals 1

    .line 245
    iget-object v0, p0, Landroid/support/v7/widget/ta;->b:Landroid/content/res/TypedArray;

    invoke-virtual {v0}, Landroid/content/res/TypedArray;->recycle()V

    .line 246
    return-void
.end method

.method public a(IZ)Z
    .locals 1
    .param p1, "index"    # I
    .param p2, "defValue"    # Z

    .line 151
    iget-object v0, p0, Landroid/support/v7/widget/ta;->b:Landroid/content/res/TypedArray;

    invoke-virtual {v0, p1, p2}, Landroid/content/res/TypedArray;->getBoolean(IZ)Z

    move-result v0

    return v0
.end method

.method public b(II)I
    .locals 1
    .param p1, "index"    # I
    .param p2, "defValue"    # I

    .line 189
    iget-object v0, p0, Landroid/support/v7/widget/ta;->b:Landroid/content/res/TypedArray;

    invoke-virtual {v0, p1, p2}, Landroid/content/res/TypedArray;->getDimensionPixelOffset(II)I

    move-result v0

    return v0
.end method

.method public b(I)Landroid/graphics/drawable/Drawable;
    .locals 2
    .param p1, "index"    # I

    .line 73
    iget-object v0, p0, Landroid/support/v7/widget/ta;->b:Landroid/content/res/TypedArray;

    invoke-virtual {v0, p1}, Landroid/content/res/TypedArray;->hasValue(I)Z

    move-result v0

    if-eqz v0, :cond_0

    .line 74
    iget-object v0, p0, Landroid/support/v7/widget/ta;->b:Landroid/content/res/TypedArray;

    const/4 v1, 0x0

    invoke-virtual {v0, p1, v1}, Landroid/content/res/TypedArray;->getResourceId(II)I

    move-result v0

    .line 75
    .local v0, "resourceId":I
    if-eqz v0, :cond_0

    .line 76
    iget-object v1, p0, Landroid/support/v7/widget/ta;->a:Landroid/content/Context;

    invoke-static {v1, v0}, La/b/d/b/a/a;->b(Landroid/content/Context;I)Landroid/graphics/drawable/Drawable;

    move-result-object v1

    return-object v1

    .line 79
    .end local v0    # "resourceId":I
    :cond_0
    iget-object v0, p0, Landroid/support/v7/widget/ta;->b:Landroid/content/res/TypedArray;

    invoke-virtual {v0, p1}, Landroid/content/res/TypedArray;->getDrawable(I)Landroid/graphics/drawable/Drawable;

    move-result-object v0

    return-object v0
.end method

.method public c(II)I
    .locals 1
    .param p1, "index"    # I
    .param p2, "defValue"    # I

    .line 193
    iget-object v0, p0, Landroid/support/v7/widget/ta;->b:Landroid/content/res/TypedArray;

    invoke-virtual {v0, p1, p2}, Landroid/content/res/TypedArray;->getDimensionPixelSize(II)I

    move-result v0

    return v0
.end method

.method public c(I)Landroid/graphics/drawable/Drawable;
    .locals 4
    .param p1, "index"    # I

    .line 83
    iget-object v0, p0, Landroid/support/v7/widget/ta;->b:Landroid/content/res/TypedArray;

    invoke-virtual {v0, p1}, Landroid/content/res/TypedArray;->hasValue(I)Z

    move-result v0

    if-eqz v0, :cond_0

    .line 84
    iget-object v0, p0, Landroid/support/v7/widget/ta;->b:Landroid/content/res/TypedArray;

    const/4 v1, 0x0

    invoke-virtual {v0, p1, v1}, Landroid/content/res/TypedArray;->getResourceId(II)I

    move-result v0

    .line 85
    .local v0, "resourceId":I
    if-eqz v0, :cond_0

    .line 86
    invoke-static {}, Landroid/support/v7/widget/o;->a()Landroid/support/v7/widget/o;

    move-result-object v1

    iget-object v2, p0, Landroid/support/v7/widget/ta;->a:Landroid/content/Context;

    const/4 v3, 0x1

    invoke-virtual {v1, v2, v0, v3}, Landroid/support/v7/widget/o;->a(Landroid/content/Context;IZ)Landroid/graphics/drawable/Drawable;

    move-result-object v1

    return-object v1

    .line 89
    .end local v0    # "resourceId":I
    :cond_0
    const/4 v0, 0x0

    return-object v0
.end method

.method public d(II)I
    .locals 1
    .param p1, "index"    # I
    .param p2, "defValue"    # I

    .line 155
    iget-object v0, p0, Landroid/support/v7/widget/ta;->b:Landroid/content/res/TypedArray;

    invoke-virtual {v0, p1, p2}, Landroid/content/res/TypedArray;->getInt(II)I

    move-result v0

    return v0
.end method

.method public d(I)Ljava/lang/String;
    .locals 1
    .param p1, "index"    # I

    .line 143
    iget-object v0, p0, Landroid/support/v7/widget/ta;->b:Landroid/content/res/TypedArray;

    invoke-virtual {v0, p1}, Landroid/content/res/TypedArray;->getString(I)Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method

.method public e(II)I
    .locals 1
    .param p1, "index"    # I
    .param p2, "defValue"    # I

    .line 181
    iget-object v0, p0, Landroid/support/v7/widget/ta;->b:Landroid/content/res/TypedArray;

    invoke-virtual {v0, p1, p2}, Landroid/content/res/TypedArray;->getInteger(II)I

    move-result v0

    return v0
.end method

.method public e(I)Ljava/lang/CharSequence;
    .locals 1
    .param p1, "index"    # I

    .line 139
    iget-object v0, p0, Landroid/support/v7/widget/ta;->b:Landroid/content/res/TypedArray;

    invoke-virtual {v0, p1}, Landroid/content/res/TypedArray;->getText(I)Ljava/lang/CharSequence;

    move-result-object v0

    return-object v0
.end method

.method public f(II)I
    .locals 1
    .param p1, "index"    # I
    .param p2, "defValue"    # I

    .line 201
    iget-object v0, p0, Landroid/support/v7/widget/ta;->b:Landroid/content/res/TypedArray;

    invoke-virtual {v0, p1, p2}, Landroid/content/res/TypedArray;->getLayoutDimension(II)I

    move-result v0

    return v0
.end method

.method public f(I)[Ljava/lang/CharSequence;
    .locals 1
    .param p1, "index"    # I

    .line 213
    iget-object v0, p0, Landroid/support/v7/widget/ta;->b:Landroid/content/res/TypedArray;

    invoke-virtual {v0, p1}, Landroid/content/res/TypedArray;->getTextArray(I)[Ljava/lang/CharSequence;

    move-result-object v0

    return-object v0
.end method

.method public g(II)I
    .locals 1
    .param p1, "index"    # I
    .param p2, "defValue"    # I

    .line 209
    iget-object v0, p0, Landroid/support/v7/widget/ta;->b:Landroid/content/res/TypedArray;

    invoke-virtual {v0, p1, p2}, Landroid/content/res/TypedArray;->getResourceId(II)I

    move-result v0

    return v0
.end method

.method public g(I)Z
    .locals 1
    .param p1, "index"    # I

    .line 233
    iget-object v0, p0, Landroid/support/v7/widget/ta;->b:Landroid/content/res/TypedArray;

    invoke-virtual {v0, p1}, Landroid/content/res/TypedArray;->hasValue(I)Z

    move-result v0

    return v0
.end method
