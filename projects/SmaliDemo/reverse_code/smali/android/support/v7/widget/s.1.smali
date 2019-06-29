.class public Landroid/support/v7/widget/s;
.super Ljava/lang/Object;
.source ""


# instance fields
.field private final a:Landroid/widget/ImageView;

.field private b:Landroid/support/v7/widget/ra;

.field private c:Landroid/support/v7/widget/ra;

.field private d:Landroid/support/v7/widget/ra;


# direct methods
.method public constructor <init>(Landroid/widget/ImageView;)V
    .locals 0
    .param p1, "view"    # Landroid/widget/ImageView;

    .line 45
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 46
    iput-object p1, p0, Landroid/support/v7/widget/s;->a:Landroid/widget/ImageView;

    .line 47
    return-void
.end method

.method private a(Landroid/graphics/drawable/Drawable;)Z
    .locals 5
    .param p1, "imageSource"    # Landroid/graphics/drawable/Drawable;

    .line 196
    iget-object v0, p0, Landroid/support/v7/widget/s;->d:Landroid/support/v7/widget/ra;

    if-nez v0, :cond_0

    .line 197
    new-instance v0, Landroid/support/v7/widget/ra;

    invoke-direct {v0}, Landroid/support/v7/widget/ra;-><init>()V

    iput-object v0, p0, Landroid/support/v7/widget/s;->d:Landroid/support/v7/widget/ra;

    .line 199
    :cond_0
    iget-object v0, p0, Landroid/support/v7/widget/s;->d:Landroid/support/v7/widget/ra;

    .line 200
    .local v0, "info":Landroid/support/v7/widget/ra;
    invoke-virtual {v0}, Landroid/support/v7/widget/ra;->a()V

    .line 202
    iget-object v1, p0, Landroid/support/v7/widget/s;->a:Landroid/widget/ImageView;

    invoke-static {v1}, Landroid/support/v4/widget/g;->a(Landroid/widget/ImageView;)Landroid/content/res/ColorStateList;

    move-result-object v1

    .line 203
    .local v1, "tintList":Landroid/content/res/ColorStateList;
    const/4 v2, 0x1

    if-eqz v1, :cond_1

    .line 204
    iput-boolean v2, v0, Landroid/support/v7/widget/ra;->d:Z

    .line 205
    iput-object v1, v0, Landroid/support/v7/widget/ra;->a:Landroid/content/res/ColorStateList;

    .line 207
    :cond_1
    iget-object v3, p0, Landroid/support/v7/widget/s;->a:Landroid/widget/ImageView;

    invoke-static {v3}, Landroid/support/v4/widget/g;->b(Landroid/widget/ImageView;)Landroid/graphics/PorterDuff$Mode;

    move-result-object v3

    .line 208
    .local v3, "mode":Landroid/graphics/PorterDuff$Mode;
    if-eqz v3, :cond_2

    .line 209
    iput-boolean v2, v0, Landroid/support/v7/widget/ra;->c:Z

    .line 210
    iput-object v3, v0, Landroid/support/v7/widget/ra;->b:Landroid/graphics/PorterDuff$Mode;

    .line 213
    :cond_2
    iget-boolean v4, v0, Landroid/support/v7/widget/ra;->d:Z

    if-nez v4, :cond_4

    iget-boolean v4, v0, Landroid/support/v7/widget/ra;->c:Z

    if-eqz v4, :cond_3

    goto :goto_0

    .line 218
    :cond_3
    const/4 v2, 0x0

    return v2

    .line 214
    :cond_4
    :goto_0
    iget-object v4, p0, Landroid/support/v7/widget/s;->a:Landroid/widget/ImageView;

    invoke-virtual {v4}, Landroid/widget/ImageView;->getDrawableState()[I

    move-result-object v4

    invoke-static {p1, v0, v4}, Landroid/support/v7/widget/o;->a(Landroid/graphics/drawable/Drawable;Landroid/support/v7/widget/ra;[I)V

    .line 215
    return v2
.end method

.method private e()Z
    .locals 4

    .line 174
    sget v0, Landroid/os/Build$VERSION;->SDK_INT:I

    .line 175
    .local v0, "sdk":I
    const/4 v1, 0x1

    const/4 v2, 0x0

    const/16 v3, 0x15

    if-le v0, v3, :cond_1

    .line 178
    iget-object v3, p0, Landroid/support/v7/widget/s;->b:Landroid/support/v7/widget/ra;

    if-eqz v3, :cond_0

    goto :goto_0

    :cond_0
    const/4 v1, 0x0

    :goto_0
    return v1

    .line 179
    :cond_1
    if-ne v0, v3, :cond_2

    .line 183
    return v1

    .line 186
    :cond_2
    return v2
.end method


# virtual methods
.method a()V
    .locals 3

    .line 137
    iget-object v0, p0, Landroid/support/v7/widget/s;->a:Landroid/widget/ImageView;

    invoke-virtual {v0}, Landroid/widget/ImageView;->getDrawable()Landroid/graphics/drawable/Drawable;

    move-result-object v0

    .line 138
    .local v0, "imageViewDrawable":Landroid/graphics/drawable/Drawable;
    if-eqz v0, :cond_0

    .line 139
    invoke-static {v0}, Landroid/support/v7/widget/M;->b(Landroid/graphics/drawable/Drawable;)V

    .line 142
    :cond_0
    if-eqz v0, :cond_3

    .line 143
    invoke-direct {p0}, Landroid/support/v7/widget/s;->e()Z

    move-result v1

    if-eqz v1, :cond_1

    .line 144
    invoke-direct {p0, v0}, Landroid/support/v7/widget/s;->a(Landroid/graphics/drawable/Drawable;)Z

    move-result v1

    if-eqz v1, :cond_1

    .line 147
    return-void

    .line 150
    :cond_1
    iget-object v1, p0, Landroid/support/v7/widget/s;->c:Landroid/support/v7/widget/ra;

    if-eqz v1, :cond_2

    .line 151
    iget-object v2, p0, Landroid/support/v7/widget/s;->a:Landroid/widget/ImageView;

    .line 152
    invoke-virtual {v2}, Landroid/widget/ImageView;->getDrawableState()[I

    move-result-object v2

    .line 151
    invoke-static {v0, v1, v2}, Landroid/support/v7/widget/o;->a(Landroid/graphics/drawable/Drawable;Landroid/support/v7/widget/ra;[I)V

    goto :goto_0

    .line 153
    :cond_2
    iget-object v1, p0, Landroid/support/v7/widget/s;->b:Landroid/support/v7/widget/ra;

    if-eqz v1, :cond_3

    .line 154
    iget-object v2, p0, Landroid/support/v7/widget/s;->a:Landroid/widget/ImageView;

    .line 155
    invoke-virtual {v2}, Landroid/widget/ImageView;->getDrawableState()[I

    move-result-object v2

    .line 154
    invoke-static {v0, v1, v2}, Landroid/support/v7/widget/o;->a(Landroid/graphics/drawable/Drawable;Landroid/support/v7/widget/ra;[I)V

    .line 158
    :cond_3
    :goto_0
    return-void
.end method

.method public a(I)V
    .locals 2
    .param p1, "resId"    # I

    .line 85
    if-eqz p1, :cond_1

    .line 86
    iget-object v0, p0, Landroid/support/v7/widget/s;->a:Landroid/widget/ImageView;

    invoke-virtual {v0}, Landroid/widget/ImageView;->getContext()Landroid/content/Context;

    move-result-object v0

    invoke-static {v0, p1}, La/b/d/b/a/a;->b(Landroid/content/Context;I)Landroid/graphics/drawable/Drawable;

    move-result-object v0

    .line 87
    .local v0, "d":Landroid/graphics/drawable/Drawable;
    if-eqz v0, :cond_0

    .line 88
    invoke-static {v0}, Landroid/support/v7/widget/M;->b(Landroid/graphics/drawable/Drawable;)V

    .line 90
    :cond_0
    iget-object v1, p0, Landroid/support/v7/widget/s;->a:Landroid/widget/ImageView;

    invoke-virtual {v1, v0}, Landroid/widget/ImageView;->setImageDrawable(Landroid/graphics/drawable/Drawable;)V

    .line 91
    .end local v0    # "d":Landroid/graphics/drawable/Drawable;
    goto :goto_0

    .line 92
    :cond_1
    iget-object v0, p0, Landroid/support/v7/widget/s;->a:Landroid/widget/ImageView;

    const/4 v1, 0x0

    invoke-virtual {v0, v1}, Landroid/widget/ImageView;->setImageDrawable(Landroid/graphics/drawable/Drawable;)V

    .line 95
    :goto_0
    invoke-virtual {p0}, Landroid/support/v7/widget/s;->a()V

    .line 96
    return-void
.end method

.method a(Landroid/content/res/ColorStateList;)V
    .locals 2
    .param p1, "tint"    # Landroid/content/res/ColorStateList;

    .line 110
    iget-object v0, p0, Landroid/support/v7/widget/s;->c:Landroid/support/v7/widget/ra;

    if-nez v0, :cond_0

    .line 111
    new-instance v0, Landroid/support/v7/widget/ra;

    invoke-direct {v0}, Landroid/support/v7/widget/ra;-><init>()V

    iput-object v0, p0, Landroid/support/v7/widget/s;->c:Landroid/support/v7/widget/ra;

    .line 113
    :cond_0
    iget-object v0, p0, Landroid/support/v7/widget/s;->c:Landroid/support/v7/widget/ra;

    iput-object p1, v0, Landroid/support/v7/widget/ra;->a:Landroid/content/res/ColorStateList;

    .line 114
    const/4 v1, 0x1

    iput-boolean v1, v0, Landroid/support/v7/widget/ra;->d:Z

    .line 115
    invoke-virtual {p0}, Landroid/support/v7/widget/s;->a()V

    .line 116
    return-void
.end method

.method a(Landroid/graphics/PorterDuff$Mode;)V
    .locals 2
    .param p1, "tintMode"    # Landroid/graphics/PorterDuff$Mode;

    .line 123
    iget-object v0, p0, Landroid/support/v7/widget/s;->c:Landroid/support/v7/widget/ra;

    if-nez v0, :cond_0

    .line 124
    new-instance v0, Landroid/support/v7/widget/ra;

    invoke-direct {v0}, Landroid/support/v7/widget/ra;-><init>()V

    iput-object v0, p0, Landroid/support/v7/widget/s;->c:Landroid/support/v7/widget/ra;

    .line 126
    :cond_0
    iget-object v0, p0, Landroid/support/v7/widget/s;->c:Landroid/support/v7/widget/ra;

    iput-object p1, v0, Landroid/support/v7/widget/ra;->b:Landroid/graphics/PorterDuff$Mode;

    .line 127
    const/4 v1, 0x1

    iput-boolean v1, v0, Landroid/support/v7/widget/ra;->c:Z

    .line 129
    invoke-virtual {p0}, Landroid/support/v7/widget/s;->a()V

    .line 130
    return-void
.end method

.method public a(Landroid/util/AttributeSet;I)V
    .locals 5
    .param p1, "attrs"    # Landroid/util/AttributeSet;
    .param p2, "defStyleAttr"    # I

    .line 50
    iget-object v0, p0, Landroid/support/v7/widget/s;->a:Landroid/widget/ImageView;

    invoke-virtual {v0}, Landroid/widget/ImageView;->getContext()Landroid/content/Context;

    move-result-object v0

    sget-object v1, La/b/d/a/j;->AppCompatImageView:[I

    const/4 v2, 0x0

    invoke-static {v0, p1, v1, p2, v2}, Landroid/support/v7/widget/ta;->a(Landroid/content/Context;Landroid/util/AttributeSet;[III)Landroid/support/v7/widget/ta;

    move-result-object v0

    .line 53
    .local v0, "a":Landroid/support/v7/widget/ta;
    :try_start_0
    iget-object v1, p0, Landroid/support/v7/widget/s;->a:Landroid/widget/ImageView;

    invoke-virtual {v1}, Landroid/widget/ImageView;->getDrawable()Landroid/graphics/drawable/Drawable;

    move-result-object v1

    .line 54
    .local v1, "drawable":Landroid/graphics/drawable/Drawable;
    const/4 v2, -0x1

    if-nez v1, :cond_0

    .line 57
    sget v3, La/b/d/a/j;->AppCompatImageView_srcCompat:I

    invoke-virtual {v0, v3, v2}, Landroid/support/v7/widget/ta;->g(II)I

    move-result v3

    .line 58
    .local v3, "id":I
    if-eq v3, v2, :cond_0

    .line 59
    iget-object v4, p0, Landroid/support/v7/widget/s;->a:Landroid/widget/ImageView;

    invoke-virtual {v4}, Landroid/widget/ImageView;->getContext()Landroid/content/Context;

    move-result-object v4

    invoke-static {v4, v3}, La/b/d/b/a/a;->b(Landroid/content/Context;I)Landroid/graphics/drawable/Drawable;

    move-result-object v4

    move-object v1, v4

    .line 60
    if-eqz v1, :cond_0

    .line 61
    iget-object v4, p0, Landroid/support/v7/widget/s;->a:Landroid/widget/ImageView;

    invoke-virtual {v4, v1}, Landroid/widget/ImageView;->setImageDrawable(Landroid/graphics/drawable/Drawable;)V

    .line 66
    .end local v3    # "id":I
    :cond_0
    if-eqz v1, :cond_1

    .line 67
    invoke-static {v1}, Landroid/support/v7/widget/M;->b(Landroid/graphics/drawable/Drawable;)V

    .line 70
    :cond_1
    sget v3, La/b/d/a/j;->AppCompatImageView_tint:I

    invoke-virtual {v0, v3}, Landroid/support/v7/widget/ta;->g(I)Z

    move-result v3

    if-eqz v3, :cond_2

    .line 71
    iget-object v3, p0, Landroid/support/v7/widget/s;->a:Landroid/widget/ImageView;

    sget v4, La/b/d/a/j;->AppCompatImageView_tint:I

    .line 72
    invoke-virtual {v0, v4}, Landroid/support/v7/widget/ta;->a(I)Landroid/content/res/ColorStateList;

    move-result-object v4

    .line 71
    invoke-static {v3, v4}, Landroid/support/v4/widget/g;->a(Landroid/widget/ImageView;Landroid/content/res/ColorStateList;)V

    .line 74
    :cond_2
    sget v3, La/b/d/a/j;->AppCompatImageView_tintMode:I

    invoke-virtual {v0, v3}, Landroid/support/v7/widget/ta;->g(I)Z

    move-result v3

    if-eqz v3, :cond_3

    .line 75
    iget-object v3, p0, Landroid/support/v7/widget/s;->a:Landroid/widget/ImageView;

    sget v4, La/b/d/a/j;->AppCompatImageView_tintMode:I

    .line 77
    invoke-virtual {v0, v4, v2}, Landroid/support/v7/widget/ta;->d(II)I

    move-result v2

    const/4 v4, 0x0

    .line 76
    invoke-static {v2, v4}, Landroid/support/v7/widget/M;->a(ILandroid/graphics/PorterDuff$Mode;)Landroid/graphics/PorterDuff$Mode;

    move-result-object v2

    .line 75
    invoke-static {v3, v2}, Landroid/support/v4/widget/g;->a(Landroid/widget/ImageView;Landroid/graphics/PorterDuff$Mode;)V
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    .line 80
    .end local v1    # "drawable":Landroid/graphics/drawable/Drawable;
    :cond_3
    invoke-virtual {v0}, Landroid/support/v7/widget/ta;->a()V

    .line 81
    nop

    .line 82
    return-void

    .line 80
    :catchall_0
    move-exception v1

    invoke-virtual {v0}, Landroid/support/v7/widget/ta;->a()V

    throw v1
.end method

.method b()Landroid/content/res/ColorStateList;
    .locals 1

    .line 119
    iget-object v0, p0, Landroid/support/v7/widget/s;->c:Landroid/support/v7/widget/ra;

    if-eqz v0, :cond_0

    iget-object v0, v0, Landroid/support/v7/widget/ra;->a:Landroid/content/res/ColorStateList;

    goto :goto_0

    :cond_0
    const/4 v0, 0x0

    :goto_0
    return-object v0
.end method

.method c()Landroid/graphics/PorterDuff$Mode;
    .locals 1

    .line 133
    iget-object v0, p0, Landroid/support/v7/widget/s;->c:Landroid/support/v7/widget/ra;

    if-eqz v0, :cond_0

    iget-object v0, v0, Landroid/support/v7/widget/ra;->b:Landroid/graphics/PorterDuff$Mode;

    goto :goto_0

    :cond_0
    const/4 v0, 0x0

    :goto_0
    return-object v0
.end method

.method d()Z
    .locals 3

    .line 99
    iget-object v0, p0, Landroid/support/v7/widget/s;->a:Landroid/widget/ImageView;

    invoke-virtual {v0}, Landroid/widget/ImageView;->getBackground()Landroid/graphics/drawable/Drawable;

    move-result-object v0

    .line 100
    .local v0, "background":Landroid/graphics/drawable/Drawable;
    sget v1, Landroid/os/Build$VERSION;->SDK_INT:I

    const/16 v2, 0x15

    if-lt v1, v2, :cond_0

    instance-of v1, v0, Landroid/graphics/drawable/RippleDrawable;

    if-eqz v1, :cond_0

    .line 104
    const/4 v1, 0x0

    return v1

    .line 106
    :cond_0
    const/4 v1, 0x1

    return v1
.end method
