.class Landroid/support/v7/widget/j;
.super Ljava/lang/Object;
.source ""


# instance fields
.field private final a:Landroid/view/View;

.field private final b:Landroid/support/v7/widget/o;

.field private c:I

.field private d:Landroid/support/v7/widget/ra;

.field private e:Landroid/support/v7/widget/ra;

.field private f:Landroid/support/v7/widget/ra;


# direct methods
.method constructor <init>(Landroid/view/View;)V
    .locals 1
    .param p1, "view"    # Landroid/view/View;

    .line 41
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 35
    const/4 v0, -0x1

    iput v0, p0, Landroid/support/v7/widget/j;->c:I

    .line 42
    iput-object p1, p0, Landroid/support/v7/widget/j;->a:Landroid/view/View;

    .line 43
    invoke-static {}, Landroid/support/v7/widget/o;->a()Landroid/support/v7/widget/o;

    move-result-object v0

    iput-object v0, p0, Landroid/support/v7/widget/j;->b:Landroid/support/v7/widget/o;

    .line 44
    return-void
.end method

.method private b(Landroid/graphics/drawable/Drawable;)Z
    .locals 5
    .param p1, "background"    # Landroid/graphics/drawable/Drawable;

    .line 173
    iget-object v0, p0, Landroid/support/v7/widget/j;->f:Landroid/support/v7/widget/ra;

    if-nez v0, :cond_0

    .line 174
    new-instance v0, Landroid/support/v7/widget/ra;

    invoke-direct {v0}, Landroid/support/v7/widget/ra;-><init>()V

    iput-object v0, p0, Landroid/support/v7/widget/j;->f:Landroid/support/v7/widget/ra;

    .line 176
    :cond_0
    iget-object v0, p0, Landroid/support/v7/widget/j;->f:Landroid/support/v7/widget/ra;

    .line 177
    .local v0, "info":Landroid/support/v7/widget/ra;
    invoke-virtual {v0}, Landroid/support/v7/widget/ra;->a()V

    .line 179
    iget-object v1, p0, Landroid/support/v7/widget/j;->a:Landroid/view/View;

    invoke-static {v1}, La/b/c/g/u;->b(Landroid/view/View;)Landroid/content/res/ColorStateList;

    move-result-object v1

    .line 180
    .local v1, "tintList":Landroid/content/res/ColorStateList;
    const/4 v2, 0x1

    if-eqz v1, :cond_1

    .line 181
    iput-boolean v2, v0, Landroid/support/v7/widget/ra;->d:Z

    .line 182
    iput-object v1, v0, Landroid/support/v7/widget/ra;->a:Landroid/content/res/ColorStateList;

    .line 184
    :cond_1
    iget-object v3, p0, Landroid/support/v7/widget/j;->a:Landroid/view/View;

    invoke-static {v3}, La/b/c/g/u;->c(Landroid/view/View;)Landroid/graphics/PorterDuff$Mode;

    move-result-object v3

    .line 185
    .local v3, "mode":Landroid/graphics/PorterDuff$Mode;
    if-eqz v3, :cond_2

    .line 186
    iput-boolean v2, v0, Landroid/support/v7/widget/ra;->c:Z

    .line 187
    iput-object v3, v0, Landroid/support/v7/widget/ra;->b:Landroid/graphics/PorterDuff$Mode;

    .line 190
    :cond_2
    iget-boolean v4, v0, Landroid/support/v7/widget/ra;->d:Z

    if-nez v4, :cond_4

    iget-boolean v4, v0, Landroid/support/v7/widget/ra;->c:Z

    if-eqz v4, :cond_3

    goto :goto_0

    .line 195
    :cond_3
    const/4 v2, 0x0

    return v2

    .line 191
    :cond_4
    :goto_0
    iget-object v4, p0, Landroid/support/v7/widget/j;->a:Landroid/view/View;

    invoke-virtual {v4}, Landroid/view/View;->getDrawableState()[I

    move-result-object v4

    invoke-static {p1, v0, v4}, Landroid/support/v7/widget/o;->a(Landroid/graphics/drawable/Drawable;Landroid/support/v7/widget/ra;[I)V

    .line 192
    return v2
.end method

.method private d()Z
    .locals 4

    .line 151
    sget v0, Landroid/os/Build$VERSION;->SDK_INT:I

    .line 152
    .local v0, "sdk":I
    const/4 v1, 0x1

    const/4 v2, 0x0

    const/16 v3, 0x15

    if-le v0, v3, :cond_1

    .line 155
    iget-object v3, p0, Landroid/support/v7/widget/j;->d:Landroid/support/v7/widget/ra;

    if-eqz v3, :cond_0

    goto :goto_0

    :cond_0
    const/4 v1, 0x0

    :goto_0
    return v1

    .line 156
    :cond_1
    if-ne v0, v3, :cond_2

    .line 160
    return v1

    .line 163
    :cond_2
    return v2
.end method


# virtual methods
.method a()V
    .locals 3

    .line 118
    iget-object v0, p0, Landroid/support/v7/widget/j;->a:Landroid/view/View;

    invoke-virtual {v0}, Landroid/view/View;->getBackground()Landroid/graphics/drawable/Drawable;

    move-result-object v0

    .line 119
    .local v0, "background":Landroid/graphics/drawable/Drawable;
    if-eqz v0, :cond_2

    .line 120
    invoke-direct {p0}, Landroid/support/v7/widget/j;->d()Z

    move-result v1

    if-eqz v1, :cond_0

    .line 121
    invoke-direct {p0, v0}, Landroid/support/v7/widget/j;->b(Landroid/graphics/drawable/Drawable;)Z

    move-result v1

    if-eqz v1, :cond_0

    .line 124
    return-void

    .line 127
    :cond_0
    iget-object v1, p0, Landroid/support/v7/widget/j;->e:Landroid/support/v7/widget/ra;

    if-eqz v1, :cond_1

    .line 128
    iget-object v2, p0, Landroid/support/v7/widget/j;->a:Landroid/view/View;

    .line 129
    invoke-virtual {v2}, Landroid/view/View;->getDrawableState()[I

    move-result-object v2

    .line 128
    invoke-static {v0, v1, v2}, Landroid/support/v7/widget/o;->a(Landroid/graphics/drawable/Drawable;Landroid/support/v7/widget/ra;[I)V

    goto :goto_0

    .line 130
    :cond_1
    iget-object v1, p0, Landroid/support/v7/widget/j;->d:Landroid/support/v7/widget/ra;

    if-eqz v1, :cond_2

    .line 131
    iget-object v2, p0, Landroid/support/v7/widget/j;->a:Landroid/view/View;

    .line 132
    invoke-virtual {v2}, Landroid/view/View;->getDrawableState()[I

    move-result-object v2

    .line 131
    invoke-static {v0, v1, v2}, Landroid/support/v7/widget/o;->a(Landroid/graphics/drawable/Drawable;Landroid/support/v7/widget/ra;[I)V

    .line 135
    :cond_2
    :goto_0
    return-void
.end method

.method a(I)V
    .locals 2
    .param p1, "resId"    # I

    .line 75
    iput p1, p0, Landroid/support/v7/widget/j;->c:I

    .line 77
    iget-object v0, p0, Landroid/support/v7/widget/j;->b:Landroid/support/v7/widget/o;

    if-eqz v0, :cond_0

    iget-object v1, p0, Landroid/support/v7/widget/j;->a:Landroid/view/View;

    .line 78
    invoke-virtual {v1}, Landroid/view/View;->getContext()Landroid/content/Context;

    move-result-object v1

    invoke-virtual {v0, v1, p1}, Landroid/support/v7/widget/o;->b(Landroid/content/Context;I)Landroid/content/res/ColorStateList;

    move-result-object v0

    goto :goto_0

    :cond_0
    const/4 v0, 0x0

    .line 77
    :goto_0
    invoke-virtual {p0, v0}, Landroid/support/v7/widget/j;->a(Landroid/content/res/ColorStateList;)V

    .line 80
    invoke-virtual {p0}, Landroid/support/v7/widget/j;->a()V

    .line 81
    return-void
.end method

.method a(Landroid/content/res/ColorStateList;)V
    .locals 2
    .param p1, "tint"    # Landroid/content/res/ColorStateList;

    .line 138
    if-eqz p1, :cond_1

    .line 139
    iget-object v0, p0, Landroid/support/v7/widget/j;->d:Landroid/support/v7/widget/ra;

    if-nez v0, :cond_0

    .line 140
    new-instance v0, Landroid/support/v7/widget/ra;

    invoke-direct {v0}, Landroid/support/v7/widget/ra;-><init>()V

    iput-object v0, p0, Landroid/support/v7/widget/j;->d:Landroid/support/v7/widget/ra;

    .line 142
    :cond_0
    iget-object v0, p0, Landroid/support/v7/widget/j;->d:Landroid/support/v7/widget/ra;

    iput-object p1, v0, Landroid/support/v7/widget/ra;->a:Landroid/content/res/ColorStateList;

    .line 143
    const/4 v1, 0x1

    iput-boolean v1, v0, Landroid/support/v7/widget/ra;->d:Z

    goto :goto_0

    .line 145
    :cond_1
    const/4 v0, 0x0

    iput-object v0, p0, Landroid/support/v7/widget/j;->d:Landroid/support/v7/widget/ra;

    .line 147
    :goto_0
    invoke-virtual {p0}, Landroid/support/v7/widget/j;->a()V

    .line 148
    return-void
.end method

.method a(Landroid/graphics/PorterDuff$Mode;)V
    .locals 2
    .param p1, "tintMode"    # Landroid/graphics/PorterDuff$Mode;

    .line 104
    iget-object v0, p0, Landroid/support/v7/widget/j;->e:Landroid/support/v7/widget/ra;

    if-nez v0, :cond_0

    .line 105
    new-instance v0, Landroid/support/v7/widget/ra;

    invoke-direct {v0}, Landroid/support/v7/widget/ra;-><init>()V

    iput-object v0, p0, Landroid/support/v7/widget/j;->e:Landroid/support/v7/widget/ra;

    .line 107
    :cond_0
    iget-object v0, p0, Landroid/support/v7/widget/j;->e:Landroid/support/v7/widget/ra;

    iput-object p1, v0, Landroid/support/v7/widget/ra;->b:Landroid/graphics/PorterDuff$Mode;

    .line 108
    const/4 v1, 0x1

    iput-boolean v1, v0, Landroid/support/v7/widget/ra;->c:Z

    .line 110
    invoke-virtual {p0}, Landroid/support/v7/widget/j;->a()V

    .line 111
    return-void
.end method

.method a(Landroid/graphics/drawable/Drawable;)V
    .locals 1
    .param p1, "background"    # Landroid/graphics/drawable/Drawable;

    .line 84
    const/4 v0, -0x1

    iput v0, p0, Landroid/support/v7/widget/j;->c:I

    .line 86
    const/4 v0, 0x0

    invoke-virtual {p0, v0}, Landroid/support/v7/widget/j;->a(Landroid/content/res/ColorStateList;)V

    .line 87
    invoke-virtual {p0}, Landroid/support/v7/widget/j;->a()V

    .line 88
    return-void
.end method

.method a(Landroid/util/AttributeSet;I)V
    .locals 5
    .param p1, "attrs"    # Landroid/util/AttributeSet;
    .param p2, "defStyleAttr"    # I

    .line 47
    iget-object v0, p0, Landroid/support/v7/widget/j;->a:Landroid/view/View;

    invoke-virtual {v0}, Landroid/view/View;->getContext()Landroid/content/Context;

    move-result-object v0

    sget-object v1, La/b/d/a/j;->ViewBackgroundHelper:[I

    const/4 v2, 0x0

    invoke-static {v0, p1, v1, p2, v2}, Landroid/support/v7/widget/ta;->a(Landroid/content/Context;Landroid/util/AttributeSet;[III)Landroid/support/v7/widget/ta;

    move-result-object v0

    .line 50
    .local v0, "a":Landroid/support/v7/widget/ta;
    :try_start_0
    sget v1, La/b/d/a/j;->ViewBackgroundHelper_android_background:I

    invoke-virtual {v0, v1}, Landroid/support/v7/widget/ta;->g(I)Z

    move-result v1

    const/4 v2, -0x1

    if-eqz v1, :cond_0

    .line 51
    sget v1, La/b/d/a/j;->ViewBackgroundHelper_android_background:I

    invoke-virtual {v0, v1, v2}, Landroid/support/v7/widget/ta;->g(II)I

    move-result v1

    iput v1, p0, Landroid/support/v7/widget/j;->c:I

    .line 53
    iget-object v1, p0, Landroid/support/v7/widget/j;->b:Landroid/support/v7/widget/o;

    iget-object v3, p0, Landroid/support/v7/widget/j;->a:Landroid/view/View;

    .line 54
    invoke-virtual {v3}, Landroid/view/View;->getContext()Landroid/content/Context;

    move-result-object v3

    iget v4, p0, Landroid/support/v7/widget/j;->c:I

    invoke-virtual {v1, v3, v4}, Landroid/support/v7/widget/o;->b(Landroid/content/Context;I)Landroid/content/res/ColorStateList;

    move-result-object v1

    .line 55
    .local v1, "tint":Landroid/content/res/ColorStateList;
    if-eqz v1, :cond_0

    .line 56
    invoke-virtual {p0, v1}, Landroid/support/v7/widget/j;->a(Landroid/content/res/ColorStateList;)V

    .line 59
    .end local v1    # "tint":Landroid/content/res/ColorStateList;
    :cond_0
    sget v1, La/b/d/a/j;->ViewBackgroundHelper_backgroundTint:I

    invoke-virtual {v0, v1}, Landroid/support/v7/widget/ta;->g(I)Z

    move-result v1

    if-eqz v1, :cond_1

    .line 60
    iget-object v1, p0, Landroid/support/v7/widget/j;->a:Landroid/view/View;

    sget v3, La/b/d/a/j;->ViewBackgroundHelper_backgroundTint:I

    .line 61
    invoke-virtual {v0, v3}, Landroid/support/v7/widget/ta;->a(I)Landroid/content/res/ColorStateList;

    move-result-object v3

    .line 60
    invoke-static {v1, v3}, La/b/c/g/u;->a(Landroid/view/View;Landroid/content/res/ColorStateList;)V

    .line 63
    :cond_1
    sget v1, La/b/d/a/j;->ViewBackgroundHelper_backgroundTintMode:I

    invoke-virtual {v0, v1}, Landroid/support/v7/widget/ta;->g(I)Z

    move-result v1

    if-eqz v1, :cond_2

    .line 64
    iget-object v1, p0, Landroid/support/v7/widget/j;->a:Landroid/view/View;

    sget v3, La/b/d/a/j;->ViewBackgroundHelper_backgroundTintMode:I

    .line 66
    invoke-virtual {v0, v3, v2}, Landroid/support/v7/widget/ta;->d(II)I

    move-result v2

    const/4 v3, 0x0

    .line 65
    invoke-static {v2, v3}, Landroid/support/v7/widget/M;->a(ILandroid/graphics/PorterDuff$Mode;)Landroid/graphics/PorterDuff$Mode;

    move-result-object v2

    .line 64
    invoke-static {v1, v2}, La/b/c/g/u;->a(Landroid/view/View;Landroid/graphics/PorterDuff$Mode;)V
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    .line 70
    :cond_2
    invoke-virtual {v0}, Landroid/support/v7/widget/ta;->a()V

    .line 71
    nop

    .line 72
    return-void

    .line 70
    :catchall_0
    move-exception v1

    invoke-virtual {v0}, Landroid/support/v7/widget/ta;->a()V

    throw v1
.end method

.method b()Landroid/content/res/ColorStateList;
    .locals 1

    .line 100
    iget-object v0, p0, Landroid/support/v7/widget/j;->e:Landroid/support/v7/widget/ra;

    if-eqz v0, :cond_0

    iget-object v0, v0, Landroid/support/v7/widget/ra;->a:Landroid/content/res/ColorStateList;

    goto :goto_0

    :cond_0
    const/4 v0, 0x0

    :goto_0
    return-object v0
.end method

.method b(Landroid/content/res/ColorStateList;)V
    .locals 2
    .param p1, "tint"    # Landroid/content/res/ColorStateList;

    .line 91
    iget-object v0, p0, Landroid/support/v7/widget/j;->e:Landroid/support/v7/widget/ra;

    if-nez v0, :cond_0

    .line 92
    new-instance v0, Landroid/support/v7/widget/ra;

    invoke-direct {v0}, Landroid/support/v7/widget/ra;-><init>()V

    iput-object v0, p0, Landroid/support/v7/widget/j;->e:Landroid/support/v7/widget/ra;

    .line 94
    :cond_0
    iget-object v0, p0, Landroid/support/v7/widget/j;->e:Landroid/support/v7/widget/ra;

    iput-object p1, v0, Landroid/support/v7/widget/ra;->a:Landroid/content/res/ColorStateList;

    .line 95
    const/4 v1, 0x1

    iput-boolean v1, v0, Landroid/support/v7/widget/ra;->d:Z

    .line 96
    invoke-virtual {p0}, Landroid/support/v7/widget/j;->a()V

    .line 97
    return-void
.end method

.method c()Landroid/graphics/PorterDuff$Mode;
    .locals 1

    .line 114
    iget-object v0, p0, Landroid/support/v7/widget/j;->e:Landroid/support/v7/widget/ra;

    if-eqz v0, :cond_0

    iget-object v0, v0, Landroid/support/v7/widget/ra;->b:Landroid/graphics/PorterDuff$Mode;

    goto :goto_0

    :cond_0
    const/4 v0, 0x0

    :goto_0
    return-object v0
.end method
