.class Landroid/support/v7/widget/A;
.super Landroid/support/v7/widget/w;
.source ""


# instance fields
.field private final d:Landroid/widget/SeekBar;

.field private e:Landroid/graphics/drawable/Drawable;

.field private f:Landroid/content/res/ColorStateList;

.field private g:Landroid/graphics/PorterDuff$Mode;

.field private h:Z

.field private i:Z


# direct methods
.method constructor <init>(Landroid/widget/SeekBar;)V
    .locals 1
    .param p1, "view"    # Landroid/widget/SeekBar;

    .line 42
    invoke-direct {p0, p1}, Landroid/support/v7/widget/w;-><init>(Landroid/widget/ProgressBar;)V

    .line 36
    const/4 v0, 0x0

    iput-object v0, p0, Landroid/support/v7/widget/A;->f:Landroid/content/res/ColorStateList;

    .line 37
    iput-object v0, p0, Landroid/support/v7/widget/A;->g:Landroid/graphics/PorterDuff$Mode;

    .line 38
    const/4 v0, 0x0

    iput-boolean v0, p0, Landroid/support/v7/widget/A;->h:Z

    .line 39
    iput-boolean v0, p0, Landroid/support/v7/widget/A;->i:Z

    .line 43
    iput-object p1, p0, Landroid/support/v7/widget/A;->d:Landroid/widget/SeekBar;

    .line 44
    return-void
.end method

.method private d()V
    .locals 2

    .line 125
    iget-object v0, p0, Landroid/support/v7/widget/A;->e:Landroid/graphics/drawable/Drawable;

    if-eqz v0, :cond_3

    iget-boolean v0, p0, Landroid/support/v7/widget/A;->h:Z

    if-nez v0, :cond_0

    iget-boolean v0, p0, Landroid/support/v7/widget/A;->i:Z

    if-eqz v0, :cond_3

    .line 126
    :cond_0
    iget-object v0, p0, Landroid/support/v7/widget/A;->e:Landroid/graphics/drawable/Drawable;

    invoke-virtual {v0}, Landroid/graphics/drawable/Drawable;->mutate()Landroid/graphics/drawable/Drawable;

    move-result-object v0

    invoke-static {v0}, Landroid/support/v4/graphics/drawable/a;->g(Landroid/graphics/drawable/Drawable;)Landroid/graphics/drawable/Drawable;

    move-result-object v0

    iput-object v0, p0, Landroid/support/v7/widget/A;->e:Landroid/graphics/drawable/Drawable;

    .line 128
    iget-boolean v0, p0, Landroid/support/v7/widget/A;->h:Z

    if-eqz v0, :cond_1

    .line 129
    iget-object v0, p0, Landroid/support/v7/widget/A;->e:Landroid/graphics/drawable/Drawable;

    iget-object v1, p0, Landroid/support/v7/widget/A;->f:Landroid/content/res/ColorStateList;

    invoke-static {v0, v1}, Landroid/support/v4/graphics/drawable/a;->a(Landroid/graphics/drawable/Drawable;Landroid/content/res/ColorStateList;)V

    .line 132
    :cond_1
    iget-boolean v0, p0, Landroid/support/v7/widget/A;->i:Z

    if-eqz v0, :cond_2

    .line 133
    iget-object v0, p0, Landroid/support/v7/widget/A;->e:Landroid/graphics/drawable/Drawable;

    iget-object v1, p0, Landroid/support/v7/widget/A;->g:Landroid/graphics/PorterDuff$Mode;

    invoke-static {v0, v1}, Landroid/support/v4/graphics/drawable/a;->a(Landroid/graphics/drawable/Drawable;Landroid/graphics/PorterDuff$Mode;)V

    .line 138
    :cond_2
    iget-object v0, p0, Landroid/support/v7/widget/A;->e:Landroid/graphics/drawable/Drawable;

    invoke-virtual {v0}, Landroid/graphics/drawable/Drawable;->isStateful()Z

    move-result v0

    if-eqz v0, :cond_3

    .line 139
    iget-object v0, p0, Landroid/support/v7/widget/A;->e:Landroid/graphics/drawable/Drawable;

    iget-object v1, p0, Landroid/support/v7/widget/A;->d:Landroid/widget/SeekBar;

    invoke-virtual {v1}, Landroid/widget/SeekBar;->getDrawableState()[I

    move-result-object v1

    invoke-virtual {v0, v1}, Landroid/graphics/drawable/Drawable;->setState([I)Z

    .line 142
    :cond_3
    return-void
.end method


# virtual methods
.method a(Landroid/graphics/Canvas;)V
    .locals 9
    .param p1, "canvas"    # Landroid/graphics/Canvas;

    .line 162
    iget-object v0, p0, Landroid/support/v7/widget/A;->e:Landroid/graphics/drawable/Drawable;

    if-eqz v0, :cond_3

    .line 163
    iget-object v0, p0, Landroid/support/v7/widget/A;->d:Landroid/widget/SeekBar;

    invoke-virtual {v0}, Landroid/widget/SeekBar;->getMax()I

    move-result v0

    .line 164
    .local v0, "count":I
    const/4 v1, 0x1

    if-le v0, v1, :cond_3

    .line 165
    iget-object v2, p0, Landroid/support/v7/widget/A;->e:Landroid/graphics/drawable/Drawable;

    invoke-virtual {v2}, Landroid/graphics/drawable/Drawable;->getIntrinsicWidth()I

    move-result v2

    .line 166
    .local v2, "w":I
    iget-object v3, p0, Landroid/support/v7/widget/A;->e:Landroid/graphics/drawable/Drawable;

    invoke-virtual {v3}, Landroid/graphics/drawable/Drawable;->getIntrinsicHeight()I

    move-result v3

    .line 167
    .local v3, "h":I
    if-ltz v2, :cond_0

    div-int/lit8 v4, v2, 0x2

    goto :goto_0

    :cond_0
    const/4 v4, 0x1

    .line 168
    .local v4, "halfW":I
    :goto_0
    if-ltz v3, :cond_1

    div-int/lit8 v1, v3, 0x2

    .line 169
    .local v1, "halfH":I
    :cond_1
    iget-object v5, p0, Landroid/support/v7/widget/A;->e:Landroid/graphics/drawable/Drawable;

    neg-int v6, v4

    neg-int v7, v1

    invoke-virtual {v5, v6, v7, v4, v1}, Landroid/graphics/drawable/Drawable;->setBounds(IIII)V

    .line 171
    iget-object v5, p0, Landroid/support/v7/widget/A;->d:Landroid/widget/SeekBar;

    invoke-virtual {v5}, Landroid/widget/SeekBar;->getWidth()I

    move-result v5

    iget-object v6, p0, Landroid/support/v7/widget/A;->d:Landroid/widget/SeekBar;

    invoke-virtual {v6}, Landroid/widget/SeekBar;->getPaddingLeft()I

    move-result v6

    sub-int/2addr v5, v6

    iget-object v6, p0, Landroid/support/v7/widget/A;->d:Landroid/widget/SeekBar;

    .line 172
    invoke-virtual {v6}, Landroid/widget/SeekBar;->getPaddingRight()I

    move-result v6

    sub-int/2addr v5, v6

    int-to-float v5, v5

    int-to-float v6, v0

    div-float/2addr v5, v6

    .line 173
    .local v5, "spacing":F
    invoke-virtual {p1}, Landroid/graphics/Canvas;->save()I

    move-result v6

    .line 174
    .local v6, "saveCount":I
    iget-object v7, p0, Landroid/support/v7/widget/A;->d:Landroid/widget/SeekBar;

    invoke-virtual {v7}, Landroid/widget/SeekBar;->getPaddingLeft()I

    move-result v7

    int-to-float v7, v7

    iget-object v8, p0, Landroid/support/v7/widget/A;->d:Landroid/widget/SeekBar;

    invoke-virtual {v8}, Landroid/widget/SeekBar;->getHeight()I

    move-result v8

    div-int/lit8 v8, v8, 0x2

    int-to-float v8, v8

    invoke-virtual {p1, v7, v8}, Landroid/graphics/Canvas;->translate(FF)V

    .line 175
    const/4 v7, 0x0

    .local v7, "i":I
    :goto_1
    if-gt v7, v0, :cond_2

    .line 176
    iget-object v8, p0, Landroid/support/v7/widget/A;->e:Landroid/graphics/drawable/Drawable;

    invoke-virtual {v8, p1}, Landroid/graphics/drawable/Drawable;->draw(Landroid/graphics/Canvas;)V

    .line 177
    const/4 v8, 0x0

    invoke-virtual {p1, v5, v8}, Landroid/graphics/Canvas;->translate(FF)V

    .line 175
    add-int/lit8 v7, v7, 0x1

    goto :goto_1

    .line 179
    .end local v7    # "i":I
    :cond_2
    invoke-virtual {p1, v6}, Landroid/graphics/Canvas;->restoreToCount(I)V

    .line 182
    .end local v0    # "count":I
    .end local v1    # "halfH":I
    .end local v2    # "w":I
    .end local v3    # "h":I
    .end local v4    # "halfW":I
    .end local v5    # "spacing":F
    .end local v6    # "saveCount":I
    :cond_3
    return-void
.end method

.method a(Landroid/graphics/drawable/Drawable;)V
    .locals 2
    .param p1, "tickMark"    # Landroid/graphics/drawable/Drawable;

    .line 77
    iget-object v0, p0, Landroid/support/v7/widget/A;->e:Landroid/graphics/drawable/Drawable;

    if-eqz v0, :cond_0

    .line 78
    const/4 v1, 0x0

    invoke-virtual {v0, v1}, Landroid/graphics/drawable/Drawable;->setCallback(Landroid/graphics/drawable/Drawable$Callback;)V

    .line 81
    :cond_0
    iput-object p1, p0, Landroid/support/v7/widget/A;->e:Landroid/graphics/drawable/Drawable;

    .line 83
    if-eqz p1, :cond_2

    .line 84
    iget-object v0, p0, Landroid/support/v7/widget/A;->d:Landroid/widget/SeekBar;

    invoke-virtual {p1, v0}, Landroid/graphics/drawable/Drawable;->setCallback(Landroid/graphics/drawable/Drawable$Callback;)V

    .line 85
    iget-object v0, p0, Landroid/support/v7/widget/A;->d:Landroid/widget/SeekBar;

    invoke-static {v0}, La/b/c/g/u;->d(Landroid/view/View;)I

    move-result v0

    invoke-static {p1, v0}, Landroid/support/v4/graphics/drawable/a;->a(Landroid/graphics/drawable/Drawable;I)Z

    .line 86
    invoke-virtual {p1}, Landroid/graphics/drawable/Drawable;->isStateful()Z

    move-result v0

    if-eqz v0, :cond_1

    .line 87
    iget-object v0, p0, Landroid/support/v7/widget/A;->d:Landroid/widget/SeekBar;

    invoke-virtual {v0}, Landroid/widget/SeekBar;->getDrawableState()[I

    move-result-object v0

    invoke-virtual {p1, v0}, Landroid/graphics/drawable/Drawable;->setState([I)Z

    .line 89
    :cond_1
    invoke-direct {p0}, Landroid/support/v7/widget/A;->d()V

    .line 92
    :cond_2
    iget-object v0, p0, Landroid/support/v7/widget/A;->d:Landroid/widget/SeekBar;

    invoke-virtual {v0}, Landroid/widget/SeekBar;->invalidate()V

    .line 93
    return-void
.end method

.method a(Landroid/util/AttributeSet;I)V
    .locals 6
    .param p1, "attrs"    # Landroid/util/AttributeSet;
    .param p2, "defStyleAttr"    # I

    .line 48
    invoke-super {p0, p1, p2}, Landroid/support/v7/widget/w;->a(Landroid/util/AttributeSet;I)V

    .line 50
    iget-object v0, p0, Landroid/support/v7/widget/A;->d:Landroid/widget/SeekBar;

    invoke-virtual {v0}, Landroid/widget/SeekBar;->getContext()Landroid/content/Context;

    move-result-object v0

    sget-object v1, La/b/d/a/j;->AppCompatSeekBar:[I

    const/4 v2, 0x0

    invoke-static {v0, p1, v1, p2, v2}, Landroid/support/v7/widget/ta;->a(Landroid/content/Context;Landroid/util/AttributeSet;[III)Landroid/support/v7/widget/ta;

    move-result-object v0

    .line 52
    .local v0, "a":Landroid/support/v7/widget/ta;
    sget v1, La/b/d/a/j;->AppCompatSeekBar_android_thumb:I

    invoke-virtual {v0, v1}, Landroid/support/v7/widget/ta;->c(I)Landroid/graphics/drawable/Drawable;

    move-result-object v1

    .line 53
    .local v1, "drawable":Landroid/graphics/drawable/Drawable;
    if-eqz v1, :cond_0

    .line 54
    iget-object v2, p0, Landroid/support/v7/widget/A;->d:Landroid/widget/SeekBar;

    invoke-virtual {v2, v1}, Landroid/widget/SeekBar;->setThumb(Landroid/graphics/drawable/Drawable;)V

    .line 57
    :cond_0
    sget v2, La/b/d/a/j;->AppCompatSeekBar_tickMark:I

    invoke-virtual {v0, v2}, Landroid/support/v7/widget/ta;->b(I)Landroid/graphics/drawable/Drawable;

    move-result-object v2

    .line 58
    .local v2, "tickMark":Landroid/graphics/drawable/Drawable;
    invoke-virtual {p0, v2}, Landroid/support/v7/widget/A;->a(Landroid/graphics/drawable/Drawable;)V

    .line 60
    sget v3, La/b/d/a/j;->AppCompatSeekBar_tickMarkTintMode:I

    invoke-virtual {v0, v3}, Landroid/support/v7/widget/ta;->g(I)Z

    move-result v3

    const/4 v4, 0x1

    if-eqz v3, :cond_1

    .line 61
    sget v3, La/b/d/a/j;->AppCompatSeekBar_tickMarkTintMode:I

    const/4 v5, -0x1

    invoke-virtual {v0, v3, v5}, Landroid/support/v7/widget/ta;->d(II)I

    move-result v3

    iget-object v5, p0, Landroid/support/v7/widget/A;->g:Landroid/graphics/PorterDuff$Mode;

    invoke-static {v3, v5}, Landroid/support/v7/widget/M;->a(ILandroid/graphics/PorterDuff$Mode;)Landroid/graphics/PorterDuff$Mode;

    move-result-object v3

    iput-object v3, p0, Landroid/support/v7/widget/A;->g:Landroid/graphics/PorterDuff$Mode;

    .line 63
    iput-boolean v4, p0, Landroid/support/v7/widget/A;->i:Z

    .line 66
    :cond_1
    sget v3, La/b/d/a/j;->AppCompatSeekBar_tickMarkTint:I

    invoke-virtual {v0, v3}, Landroid/support/v7/widget/ta;->g(I)Z

    move-result v3

    if-eqz v3, :cond_2

    .line 67
    sget v3, La/b/d/a/j;->AppCompatSeekBar_tickMarkTint:I

    invoke-virtual {v0, v3}, Landroid/support/v7/widget/ta;->a(I)Landroid/content/res/ColorStateList;

    move-result-object v3

    iput-object v3, p0, Landroid/support/v7/widget/A;->f:Landroid/content/res/ColorStateList;

    .line 68
    iput-boolean v4, p0, Landroid/support/v7/widget/A;->h:Z

    .line 71
    :cond_2
    invoke-virtual {v0}, Landroid/support/v7/widget/ta;->a()V

    .line 73
    invoke-direct {p0}, Landroid/support/v7/widget/A;->d()V

    .line 74
    return-void
.end method

.method b()V
    .locals 2

    .line 151
    iget-object v0, p0, Landroid/support/v7/widget/A;->e:Landroid/graphics/drawable/Drawable;

    .line 152
    .local v0, "tickMark":Landroid/graphics/drawable/Drawable;
    if-eqz v0, :cond_0

    invoke-virtual {v0}, Landroid/graphics/drawable/Drawable;->isStateful()Z

    move-result v1

    if-eqz v1, :cond_0

    iget-object v1, p0, Landroid/support/v7/widget/A;->d:Landroid/widget/SeekBar;

    .line 153
    invoke-virtual {v1}, Landroid/widget/SeekBar;->getDrawableState()[I

    move-result-object v1

    invoke-virtual {v0, v1}, Landroid/graphics/drawable/Drawable;->setState([I)Z

    move-result v1

    if-eqz v1, :cond_0

    .line 154
    iget-object v1, p0, Landroid/support/v7/widget/A;->d:Landroid/widget/SeekBar;

    invoke-virtual {v1, v0}, Landroid/widget/SeekBar;->invalidateDrawable(Landroid/graphics/drawable/Drawable;)V

    .line 156
    :cond_0
    return-void
.end method

.method c()V
    .locals 1

    .line 145
    iget-object v0, p0, Landroid/support/v7/widget/A;->e:Landroid/graphics/drawable/Drawable;

    if-eqz v0, :cond_0

    .line 146
    invoke-virtual {v0}, Landroid/graphics/drawable/Drawable;->jumpToCurrentState()V

    .line 148
    :cond_0
    return-void
.end method
