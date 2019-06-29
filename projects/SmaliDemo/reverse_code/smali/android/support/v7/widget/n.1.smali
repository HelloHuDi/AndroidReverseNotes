.class Landroid/support/v7/widget/n;
.super Ljava/lang/Object;
.source ""


# instance fields
.field private final a:Landroid/widget/CompoundButton;

.field private b:Landroid/content/res/ColorStateList;

.field private c:Landroid/graphics/PorterDuff$Mode;

.field private d:Z

.field private e:Z

.field private f:Z


# direct methods
.method constructor <init>(Landroid/widget/CompoundButton;)V
    .locals 1
    .param p1, "view"    # Landroid/widget/CompoundButton;

    .line 51
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 37
    const/4 v0, 0x0

    iput-object v0, p0, Landroid/support/v7/widget/n;->b:Landroid/content/res/ColorStateList;

    .line 38
    iput-object v0, p0, Landroid/support/v7/widget/n;->c:Landroid/graphics/PorterDuff$Mode;

    .line 39
    const/4 v0, 0x0

    iput-boolean v0, p0, Landroid/support/v7/widget/n;->d:Z

    .line 40
    iput-boolean v0, p0, Landroid/support/v7/widget/n;->e:Z

    .line 52
    iput-object p1, p0, Landroid/support/v7/widget/n;->a:Landroid/widget/CompoundButton;

    .line 53
    return-void
.end method


# virtual methods
.method a(I)I
    .locals 2
    .param p1, "superValue"    # I

    .line 136
    sget v0, Landroid/os/Build$VERSION;->SDK_INT:I

    const/16 v1, 0x11

    if-ge v0, v1, :cond_0

    .line 139
    iget-object v0, p0, Landroid/support/v7/widget/n;->a:Landroid/widget/CompoundButton;

    invoke-static {v0}, Landroid/support/v4/widget/c;->a(Landroid/widget/CompoundButton;)Landroid/graphics/drawable/Drawable;

    move-result-object v0

    .line 140
    .local v0, "buttonDrawable":Landroid/graphics/drawable/Drawable;
    if-eqz v0, :cond_0

    .line 141
    invoke-virtual {v0}, Landroid/graphics/drawable/Drawable;->getIntrinsicWidth()I

    move-result v1

    add-int/2addr p1, v1

    .line 144
    .end local v0    # "buttonDrawable":Landroid/graphics/drawable/Drawable;
    :cond_0
    return p1
.end method

.method a()V
    .locals 2

    .line 115
    iget-object v0, p0, Landroid/support/v7/widget/n;->a:Landroid/widget/CompoundButton;

    invoke-static {v0}, Landroid/support/v4/widget/c;->a(Landroid/widget/CompoundButton;)Landroid/graphics/drawable/Drawable;

    move-result-object v0

    .line 117
    .local v0, "buttonDrawable":Landroid/graphics/drawable/Drawable;
    if-eqz v0, :cond_4

    iget-boolean v1, p0, Landroid/support/v7/widget/n;->d:Z

    if-nez v1, :cond_0

    iget-boolean v1, p0, Landroid/support/v7/widget/n;->e:Z

    if-eqz v1, :cond_4

    .line 118
    :cond_0
    invoke-static {v0}, Landroid/support/v4/graphics/drawable/a;->g(Landroid/graphics/drawable/Drawable;)Landroid/graphics/drawable/Drawable;

    move-result-object v0

    .line 119
    invoke-virtual {v0}, Landroid/graphics/drawable/Drawable;->mutate()Landroid/graphics/drawable/Drawable;

    move-result-object v0

    .line 120
    iget-boolean v1, p0, Landroid/support/v7/widget/n;->d:Z

    if-eqz v1, :cond_1

    .line 121
    iget-object v1, p0, Landroid/support/v7/widget/n;->b:Landroid/content/res/ColorStateList;

    invoke-static {v0, v1}, Landroid/support/v4/graphics/drawable/a;->a(Landroid/graphics/drawable/Drawable;Landroid/content/res/ColorStateList;)V

    .line 123
    :cond_1
    iget-boolean v1, p0, Landroid/support/v7/widget/n;->e:Z

    if-eqz v1, :cond_2

    .line 124
    iget-object v1, p0, Landroid/support/v7/widget/n;->c:Landroid/graphics/PorterDuff$Mode;

    invoke-static {v0, v1}, Landroid/support/v4/graphics/drawable/a;->a(Landroid/graphics/drawable/Drawable;Landroid/graphics/PorterDuff$Mode;)V

    .line 128
    :cond_2
    invoke-virtual {v0}, Landroid/graphics/drawable/Drawable;->isStateful()Z

    move-result v1

    if-eqz v1, :cond_3

    .line 129
    iget-object v1, p0, Landroid/support/v7/widget/n;->a:Landroid/widget/CompoundButton;

    invoke-virtual {v1}, Landroid/widget/CompoundButton;->getDrawableState()[I

    move-result-object v1

    invoke-virtual {v0, v1}, Landroid/graphics/drawable/Drawable;->setState([I)Z

    .line 131
    :cond_3
    iget-object v1, p0, Landroid/support/v7/widget/n;->a:Landroid/widget/CompoundButton;

    invoke-virtual {v1, v0}, Landroid/widget/CompoundButton;->setButtonDrawable(Landroid/graphics/drawable/Drawable;)V

    .line 133
    :cond_4
    return-void
.end method

.method a(Landroid/content/res/ColorStateList;)V
    .locals 1
    .param p1, "tint"    # Landroid/content/res/ColorStateList;

    .line 83
    iput-object p1, p0, Landroid/support/v7/widget/n;->b:Landroid/content/res/ColorStateList;

    .line 84
    const/4 v0, 0x1

    iput-boolean v0, p0, Landroid/support/v7/widget/n;->d:Z

    .line 86
    invoke-virtual {p0}, Landroid/support/v7/widget/n;->a()V

    .line 87
    return-void
.end method

.method a(Landroid/graphics/PorterDuff$Mode;)V
    .locals 1
    .param p1, "tintMode"    # Landroid/graphics/PorterDuff$Mode;

    .line 94
    iput-object p1, p0, Landroid/support/v7/widget/n;->c:Landroid/graphics/PorterDuff$Mode;

    .line 95
    const/4 v0, 0x1

    iput-boolean v0, p0, Landroid/support/v7/widget/n;->e:Z

    .line 97
    invoke-virtual {p0}, Landroid/support/v7/widget/n;->a()V

    .line 98
    return-void
.end method

.method a(Landroid/util/AttributeSet;I)V
    .locals 4
    .param p1, "attrs"    # Landroid/util/AttributeSet;
    .param p2, "defStyleAttr"    # I

    .line 56
    iget-object v0, p0, Landroid/support/v7/widget/n;->a:Landroid/widget/CompoundButton;

    invoke-virtual {v0}, Landroid/widget/CompoundButton;->getContext()Landroid/content/Context;

    move-result-object v0

    sget-object v1, La/b/d/a/j;->CompoundButton:[I

    const/4 v2, 0x0

    invoke-virtual {v0, p1, v1, p2, v2}, Landroid/content/Context;->obtainStyledAttributes(Landroid/util/AttributeSet;[III)Landroid/content/res/TypedArray;

    move-result-object v0

    .line 59
    .local v0, "a":Landroid/content/res/TypedArray;
    :try_start_0
    sget v1, La/b/d/a/j;->CompoundButton_android_button:I

    invoke-virtual {v0, v1}, Landroid/content/res/TypedArray;->hasValue(I)Z

    move-result v1

    if-eqz v1, :cond_0

    .line 60
    sget v1, La/b/d/a/j;->CompoundButton_android_button:I

    invoke-virtual {v0, v1, v2}, Landroid/content/res/TypedArray;->getResourceId(II)I

    move-result v1

    .line 62
    .local v1, "resourceId":I
    if-eqz v1, :cond_0

    .line 63
    iget-object v2, p0, Landroid/support/v7/widget/n;->a:Landroid/widget/CompoundButton;

    iget-object v3, p0, Landroid/support/v7/widget/n;->a:Landroid/widget/CompoundButton;

    .line 64
    invoke-virtual {v3}, Landroid/widget/CompoundButton;->getContext()Landroid/content/Context;

    move-result-object v3

    invoke-static {v3, v1}, La/b/d/b/a/a;->b(Landroid/content/Context;I)Landroid/graphics/drawable/Drawable;

    move-result-object v3

    .line 63
    invoke-virtual {v2, v3}, Landroid/widget/CompoundButton;->setButtonDrawable(Landroid/graphics/drawable/Drawable;)V

    .line 67
    .end local v1    # "resourceId":I
    :cond_0
    sget v1, La/b/d/a/j;->CompoundButton_buttonTint:I

    invoke-virtual {v0, v1}, Landroid/content/res/TypedArray;->hasValue(I)Z

    move-result v1

    if-eqz v1, :cond_1

    .line 68
    iget-object v1, p0, Landroid/support/v7/widget/n;->a:Landroid/widget/CompoundButton;

    sget v2, La/b/d/a/j;->CompoundButton_buttonTint:I

    .line 69
    invoke-virtual {v0, v2}, Landroid/content/res/TypedArray;->getColorStateList(I)Landroid/content/res/ColorStateList;

    move-result-object v2

    .line 68
    invoke-static {v1, v2}, Landroid/support/v4/widget/c;->a(Landroid/widget/CompoundButton;Landroid/content/res/ColorStateList;)V

    .line 71
    :cond_1
    sget v1, La/b/d/a/j;->CompoundButton_buttonTintMode:I

    invoke-virtual {v0, v1}, Landroid/content/res/TypedArray;->hasValue(I)Z

    move-result v1

    if-eqz v1, :cond_2

    .line 72
    iget-object v1, p0, Landroid/support/v7/widget/n;->a:Landroid/widget/CompoundButton;

    sget v2, La/b/d/a/j;->CompoundButton_buttonTintMode:I

    const/4 v3, -0x1

    .line 74
    invoke-virtual {v0, v2, v3}, Landroid/content/res/TypedArray;->getInt(II)I

    move-result v2

    const/4 v3, 0x0

    .line 73
    invoke-static {v2, v3}, Landroid/support/v7/widget/M;->a(ILandroid/graphics/PorterDuff$Mode;)Landroid/graphics/PorterDuff$Mode;

    move-result-object v2

    .line 72
    invoke-static {v1, v2}, Landroid/support/v4/widget/c;->a(Landroid/widget/CompoundButton;Landroid/graphics/PorterDuff$Mode;)V
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    .line 78
    :cond_2
    invoke-virtual {v0}, Landroid/content/res/TypedArray;->recycle()V

    .line 79
    nop

    .line 80
    return-void

    .line 78
    :catchall_0
    move-exception v1

    invoke-virtual {v0}, Landroid/content/res/TypedArray;->recycle()V

    throw v1
.end method

.method b()Landroid/content/res/ColorStateList;
    .locals 1

    .line 90
    iget-object v0, p0, Landroid/support/v7/widget/n;->b:Landroid/content/res/ColorStateList;

    return-object v0
.end method

.method c()Landroid/graphics/PorterDuff$Mode;
    .locals 1

    .line 101
    iget-object v0, p0, Landroid/support/v7/widget/n;->c:Landroid/graphics/PorterDuff$Mode;

    return-object v0
.end method

.method d()V
    .locals 1

    .line 105
    iget-boolean v0, p0, Landroid/support/v7/widget/n;->f:Z

    if-eqz v0, :cond_0

    .line 106
    const/4 v0, 0x0

    iput-boolean v0, p0, Landroid/support/v7/widget/n;->f:Z

    .line 107
    return-void

    .line 110
    :cond_0
    const/4 v0, 0x1

    iput-boolean v0, p0, Landroid/support/v7/widget/n;->f:Z

    .line 111
    invoke-virtual {p0}, Landroid/support/v7/widget/n;->a()V

    .line 112
    return-void
.end method
