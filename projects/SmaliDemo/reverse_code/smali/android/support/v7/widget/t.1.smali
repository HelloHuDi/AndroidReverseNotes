.class public Landroid/support/v7/widget/t;
.super Landroid/widget/ImageView;
.source ""

# interfaces
.implements La/b/c/g/s;
.implements Landroid/support/v4/widget/o;


# instance fields
.field private final a:Landroid/support/v7/widget/j;

.field private final b:Landroid/support/v7/widget/s;


# direct methods
.method public constructor <init>(Landroid/content/Context;)V
    .locals 1
    .param p1, "context"    # Landroid/content/Context;

    .line 64
    const/4 v0, 0x0

    invoke-direct {p0, p1, v0}, Landroid/support/v7/widget/t;-><init>(Landroid/content/Context;Landroid/util/AttributeSet;)V

    .line 65
    return-void
.end method

.method public constructor <init>(Landroid/content/Context;Landroid/util/AttributeSet;)V
    .locals 1
    .param p1, "context"    # Landroid/content/Context;
    .param p2, "attrs"    # Landroid/util/AttributeSet;

    .line 68
    const/4 v0, 0x0

    invoke-direct {p0, p1, p2, v0}, Landroid/support/v7/widget/t;-><init>(Landroid/content/Context;Landroid/util/AttributeSet;I)V

    .line 69
    return-void
.end method

.method public constructor <init>(Landroid/content/Context;Landroid/util/AttributeSet;I)V
    .locals 1
    .param p1, "context"    # Landroid/content/Context;
    .param p2, "attrs"    # Landroid/util/AttributeSet;
    .param p3, "defStyleAttr"    # I

    .line 72
    invoke-static {p1}, Landroid/support/v7/widget/qa;->a(Landroid/content/Context;)Landroid/content/Context;

    move-result-object v0

    invoke-direct {p0, v0, p2, p3}, Landroid/widget/ImageView;-><init>(Landroid/content/Context;Landroid/util/AttributeSet;I)V

    .line 74
    new-instance v0, Landroid/support/v7/widget/j;

    invoke-direct {v0, p0}, Landroid/support/v7/widget/j;-><init>(Landroid/view/View;)V

    iput-object v0, p0, Landroid/support/v7/widget/t;->a:Landroid/support/v7/widget/j;

    .line 75
    iget-object v0, p0, Landroid/support/v7/widget/t;->a:Landroid/support/v7/widget/j;

    invoke-virtual {v0, p2, p3}, Landroid/support/v7/widget/j;->a(Landroid/util/AttributeSet;I)V

    .line 77
    new-instance v0, Landroid/support/v7/widget/s;

    invoke-direct {v0, p0}, Landroid/support/v7/widget/s;-><init>(Landroid/widget/ImageView;)V

    iput-object v0, p0, Landroid/support/v7/widget/t;->b:Landroid/support/v7/widget/s;

    .line 78
    iget-object v0, p0, Landroid/support/v7/widget/t;->b:Landroid/support/v7/widget/s;

    invoke-virtual {v0, p2, p3}, Landroid/support/v7/widget/s;->a(Landroid/util/AttributeSet;I)V

    .line 79
    return-void
.end method


# virtual methods
.method protected drawableStateChanged()V
    .locals 1

    .line 252
    invoke-super {p0}, Landroid/widget/ImageView;->drawableStateChanged()V

    .line 253
    iget-object v0, p0, Landroid/support/v7/widget/t;->a:Landroid/support/v7/widget/j;

    if-eqz v0, :cond_0

    .line 254
    invoke-virtual {v0}, Landroid/support/v7/widget/j;->a()V

    .line 256
    :cond_0
    iget-object v0, p0, Landroid/support/v7/widget/t;->b:Landroid/support/v7/widget/s;

    if-eqz v0, :cond_1

    .line 257
    invoke-virtual {v0}, Landroid/support/v7/widget/s;->a()V

    .line 259
    :cond_1
    return-void
.end method

.method public getSupportBackgroundTintList()Landroid/content/res/ColorStateList;
    .locals 1

    .line 162
    iget-object v0, p0, Landroid/support/v7/widget/t;->a:Landroid/support/v7/widget/j;

    if-eqz v0, :cond_0

    .line 163
    invoke-virtual {v0}, Landroid/support/v7/widget/j;->b()Landroid/content/res/ColorStateList;

    move-result-object v0

    goto :goto_0

    :cond_0
    const/4 v0, 0x0

    :goto_0
    return-object v0
.end method

.method public getSupportBackgroundTintMode()Landroid/graphics/PorterDuff$Mode;
    .locals 1

    .line 190
    iget-object v0, p0, Landroid/support/v7/widget/t;->a:Landroid/support/v7/widget/j;

    if-eqz v0, :cond_0

    .line 191
    invoke-virtual {v0}, Landroid/support/v7/widget/j;->c()Landroid/graphics/PorterDuff$Mode;

    move-result-object v0

    goto :goto_0

    :cond_0
    const/4 v0, 0x0

    :goto_0
    return-object v0
.end method

.method public getSupportImageTintList()Landroid/content/res/ColorStateList;
    .locals 1

    .line 218
    iget-object v0, p0, Landroid/support/v7/widget/t;->b:Landroid/support/v7/widget/s;

    if-eqz v0, :cond_0

    .line 219
    invoke-virtual {v0}, Landroid/support/v7/widget/s;->b()Landroid/content/res/ColorStateList;

    move-result-object v0

    goto :goto_0

    :cond_0
    const/4 v0, 0x0

    :goto_0
    return-object v0
.end method

.method public getSupportImageTintMode()Landroid/graphics/PorterDuff$Mode;
    .locals 1

    .line 246
    iget-object v0, p0, Landroid/support/v7/widget/t;->b:Landroid/support/v7/widget/s;

    if-eqz v0, :cond_0

    .line 247
    invoke-virtual {v0}, Landroid/support/v7/widget/s;->c()Landroid/graphics/PorterDuff$Mode;

    move-result-object v0

    goto :goto_0

    :cond_0
    const/4 v0, 0x0

    :goto_0
    return-object v0
.end method

.method public hasOverlappingRendering()Z
    .locals 1

    .line 263
    iget-object v0, p0, Landroid/support/v7/widget/t;->b:Landroid/support/v7/widget/s;

    invoke-virtual {v0}, Landroid/support/v7/widget/s;->d()Z

    move-result v0

    if-eqz v0, :cond_0

    invoke-super {p0}, Landroid/widget/ImageView;->hasOverlappingRendering()Z

    move-result v0

    if-eqz v0, :cond_0

    const/4 v0, 0x1

    goto :goto_0

    :cond_0
    const/4 v0, 0x0

    :goto_0
    return v0
.end method

.method public setBackgroundDrawable(Landroid/graphics/drawable/Drawable;)V
    .locals 1
    .param p1, "background"    # Landroid/graphics/drawable/Drawable;

    .line 132
    invoke-super {p0, p1}, Landroid/widget/ImageView;->setBackgroundDrawable(Landroid/graphics/drawable/Drawable;)V

    .line 133
    iget-object v0, p0, Landroid/support/v7/widget/t;->a:Landroid/support/v7/widget/j;

    if-eqz v0, :cond_0

    .line 134
    invoke-virtual {v0, p1}, Landroid/support/v7/widget/j;->a(Landroid/graphics/drawable/Drawable;)V

    .line 136
    :cond_0
    return-void
.end method

.method public setBackgroundResource(I)V
    .locals 1
    .param p1, "resId"    # I

    .line 124
    invoke-super {p0, p1}, Landroid/widget/ImageView;->setBackgroundResource(I)V

    .line 125
    iget-object v0, p0, Landroid/support/v7/widget/t;->a:Landroid/support/v7/widget/j;

    if-eqz v0, :cond_0

    .line 126
    invoke-virtual {v0, p1}, Landroid/support/v7/widget/j;->a(I)V

    .line 128
    :cond_0
    return-void
.end method

.method public setImageBitmap(Landroid/graphics/Bitmap;)V
    .locals 1
    .param p1, "bm"    # Landroid/graphics/Bitmap;

    .line 108
    invoke-super {p0, p1}, Landroid/widget/ImageView;->setImageBitmap(Landroid/graphics/Bitmap;)V

    .line 109
    iget-object v0, p0, Landroid/support/v7/widget/t;->b:Landroid/support/v7/widget/s;

    if-eqz v0, :cond_0

    .line 110
    invoke-virtual {v0}, Landroid/support/v7/widget/s;->a()V

    .line 112
    :cond_0
    return-void
.end method

.method public setImageDrawable(Landroid/graphics/drawable/Drawable;)V
    .locals 1
    .param p1, "drawable"    # Landroid/graphics/drawable/Drawable;

    .line 100
    invoke-super {p0, p1}, Landroid/widget/ImageView;->setImageDrawable(Landroid/graphics/drawable/Drawable;)V

    .line 101
    iget-object v0, p0, Landroid/support/v7/widget/t;->b:Landroid/support/v7/widget/s;

    if-eqz v0, :cond_0

    .line 102
    invoke-virtual {v0}, Landroid/support/v7/widget/s;->a()V

    .line 104
    :cond_0
    return-void
.end method

.method public setImageResource(I)V
    .locals 1
    .param p1, "resId"    # I

    .line 92
    iget-object v0, p0, Landroid/support/v7/widget/t;->b:Landroid/support/v7/widget/s;

    if-eqz v0, :cond_0

    .line 94
    invoke-virtual {v0, p1}, Landroid/support/v7/widget/s;->a(I)V

    .line 96
    :cond_0
    return-void
.end method

.method public setImageURI(Landroid/net/Uri;)V
    .locals 1
    .param p1, "uri"    # Landroid/net/Uri;

    .line 116
    invoke-super {p0, p1}, Landroid/widget/ImageView;->setImageURI(Landroid/net/Uri;)V

    .line 117
    iget-object v0, p0, Landroid/support/v7/widget/t;->b:Landroid/support/v7/widget/s;

    if-eqz v0, :cond_0

    .line 118
    invoke-virtual {v0}, Landroid/support/v7/widget/s;->a()V

    .line 120
    :cond_0
    return-void
.end method

.method public setSupportBackgroundTintList(Landroid/content/res/ColorStateList;)V
    .locals 1
    .param p1, "tint"    # Landroid/content/res/ColorStateList;

    .line 147
    iget-object v0, p0, Landroid/support/v7/widget/t;->a:Landroid/support/v7/widget/j;

    if-eqz v0, :cond_0

    .line 148
    invoke-virtual {v0, p1}, Landroid/support/v7/widget/j;->b(Landroid/content/res/ColorStateList;)V

    .line 150
    :cond_0
    return-void
.end method

.method public setSupportBackgroundTintMode(Landroid/graphics/PorterDuff$Mode;)V
    .locals 1
    .param p1, "tintMode"    # Landroid/graphics/PorterDuff$Mode;

    .line 175
    iget-object v0, p0, Landroid/support/v7/widget/t;->a:Landroid/support/v7/widget/j;

    if-eqz v0, :cond_0

    .line 176
    invoke-virtual {v0, p1}, Landroid/support/v7/widget/j;->a(Landroid/graphics/PorterDuff$Mode;)V

    .line 178
    :cond_0
    return-void
.end method

.method public setSupportImageTintList(Landroid/content/res/ColorStateList;)V
    .locals 1
    .param p1, "tint"    # Landroid/content/res/ColorStateList;

    .line 203
    iget-object v0, p0, Landroid/support/v7/widget/t;->b:Landroid/support/v7/widget/s;

    if-eqz v0, :cond_0

    .line 204
    invoke-virtual {v0, p1}, Landroid/support/v7/widget/s;->a(Landroid/content/res/ColorStateList;)V

    .line 206
    :cond_0
    return-void
.end method

.method public setSupportImageTintMode(Landroid/graphics/PorterDuff$Mode;)V
    .locals 1
    .param p1, "tintMode"    # Landroid/graphics/PorterDuff$Mode;

    .line 231
    iget-object v0, p0, Landroid/support/v7/widget/t;->b:Landroid/support/v7/widget/s;

    if-eqz v0, :cond_0

    .line 232
    invoke-virtual {v0, p1}, Landroid/support/v7/widget/s;->a(Landroid/graphics/PorterDuff$Mode;)V

    .line 234
    :cond_0
    return-void
.end method
