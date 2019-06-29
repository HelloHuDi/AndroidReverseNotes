.class public Landroid/support/v7/widget/I;
.super Landroid/widget/TextView;
.source ""

# interfaces
.implements La/b/c/g/s;
.implements Landroid/support/v4/widget/b;


# instance fields
.field private final a:Landroid/support/v7/widget/j;

.field private final b:Landroid/support/v7/widget/H;

.field private c:Ljava/util/concurrent/Future;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/concurrent/Future<",
            "La/b/c/e/a;",
            ">;"
        }
    .end annotation
.end field


# direct methods
.method public constructor <init>(Landroid/content/Context;)V
    .locals 1
    .param p1, "context"    # Landroid/content/Context;

    .line 79
    const/4 v0, 0x0

    invoke-direct {p0, p1, v0}, Landroid/support/v7/widget/I;-><init>(Landroid/content/Context;Landroid/util/AttributeSet;)V

    .line 80
    return-void
.end method

.method public constructor <init>(Landroid/content/Context;Landroid/util/AttributeSet;)V
    .locals 1
    .param p1, "context"    # Landroid/content/Context;
    .param p2, "attrs"    # Landroid/util/AttributeSet;

    .line 83
    const v0, 0x1010084

    invoke-direct {p0, p1, p2, v0}, Landroid/support/v7/widget/I;-><init>(Landroid/content/Context;Landroid/util/AttributeSet;I)V

    .line 84
    return-void
.end method

.method public constructor <init>(Landroid/content/Context;Landroid/util/AttributeSet;I)V
    .locals 1
    .param p1, "context"    # Landroid/content/Context;
    .param p2, "attrs"    # Landroid/util/AttributeSet;
    .param p3, "defStyleAttr"    # I

    .line 87
    invoke-static {p1}, Landroid/support/v7/widget/qa;->a(Landroid/content/Context;)Landroid/content/Context;

    move-result-object v0

    invoke-direct {p0, v0, p2, p3}, Landroid/widget/TextView;-><init>(Landroid/content/Context;Landroid/util/AttributeSet;I)V

    .line 89
    new-instance v0, Landroid/support/v7/widget/j;

    invoke-direct {v0, p0}, Landroid/support/v7/widget/j;-><init>(Landroid/view/View;)V

    iput-object v0, p0, Landroid/support/v7/widget/I;->a:Landroid/support/v7/widget/j;

    .line 90
    iget-object v0, p0, Landroid/support/v7/widget/I;->a:Landroid/support/v7/widget/j;

    invoke-virtual {v0, p2, p3}, Landroid/support/v7/widget/j;->a(Landroid/util/AttributeSet;I)V

    .line 92
    new-instance v0, Landroid/support/v7/widget/H;

    invoke-direct {v0, p0}, Landroid/support/v7/widget/H;-><init>(Landroid/widget/TextView;)V

    iput-object v0, p0, Landroid/support/v7/widget/I;->b:Landroid/support/v7/widget/H;

    .line 93
    iget-object v0, p0, Landroid/support/v7/widget/I;->b:Landroid/support/v7/widget/H;

    invoke-virtual {v0, p2, p3}, Landroid/support/v7/widget/H;->a(Landroid/util/AttributeSet;I)V

    .line 94
    iget-object v0, p0, Landroid/support/v7/widget/I;->b:Landroid/support/v7/widget/H;

    invoke-virtual {v0}, Landroid/support/v7/widget/H;->a()V

    .line 95
    return-void
.end method

.method private d()V
    .locals 2

    .line 464
    iget-object v0, p0, Landroid/support/v7/widget/I;->c:Ljava/util/concurrent/Future;

    if-eqz v0, :cond_0

    .line 466
    nop

    .line 467
    .local v0, "future":Ljava/util/concurrent/Future;, "Ljava/util/concurrent/Future<Landroid/support/v4/text/PrecomputedTextCompat;>;"
    const/4 v1, 0x0

    :try_start_0
    iput-object v1, p0, Landroid/support/v7/widget/I;->c:Ljava/util/concurrent/Future;

    .line 468
    invoke-interface {v0}, Ljava/util/concurrent/Future;->get()Ljava/lang/Object;

    move-result-object v1

    check-cast v1, La/b/c/e/a;

    invoke-static {p0, v1}, Landroid/support/v4/widget/m;->a(Landroid/widget/TextView;La/b/c/e/a;)V
    :try_end_0
    .catch Ljava/lang/InterruptedException; {:try_start_0 .. :try_end_0} :catch_1
    .catch Ljava/util/concurrent/ExecutionException; {:try_start_0 .. :try_end_0} :catch_0

    .line 471
    .end local v0    # "future":Ljava/util/concurrent/Future;, "Ljava/util/concurrent/Future<Landroid/support/v4/text/PrecomputedTextCompat;>;"
    goto :goto_0

    .line 469
    :catch_0
    move-exception v0

    goto :goto_0

    :catch_1
    move-exception v0

    .line 473
    :cond_0
    :goto_0
    return-void
.end method


# virtual methods
.method protected drawableStateChanged()V
    .locals 1

    .line 179
    invoke-super {p0}, Landroid/widget/TextView;->drawableStateChanged()V

    .line 180
    iget-object v0, p0, Landroid/support/v7/widget/I;->a:Landroid/support/v7/widget/j;

    if-eqz v0, :cond_0

    .line 181
    invoke-virtual {v0}, Landroid/support/v7/widget/j;->a()V

    .line 183
    :cond_0
    iget-object v0, p0, Landroid/support/v7/widget/I;->b:Landroid/support/v7/widget/H;

    if-eqz v0, :cond_1

    .line 184
    invoke-virtual {v0}, Landroid/support/v7/widget/H;->a()V

    .line 186
    :cond_1
    return-void
.end method

.method public getAutoSizeMaxTextSize()I
    .locals 1

    .line 349
    sget-boolean v0, Landroid/support/v4/widget/b;->a:Z

    if-eqz v0, :cond_0

    .line 350
    invoke-super {p0}, Landroid/widget/TextView;->getAutoSizeMaxTextSize()I

    move-result v0

    return v0

    .line 352
    :cond_0
    iget-object v0, p0, Landroid/support/v7/widget/I;->b:Landroid/support/v7/widget/H;

    if-eqz v0, :cond_1

    .line 353
    invoke-virtual {v0}, Landroid/support/v7/widget/H;->c()I

    move-result v0

    return v0

    .line 356
    :cond_1
    const/4 v0, -0x1

    return v0
.end method

.method public getAutoSizeMinTextSize()I
    .locals 1

    .line 330
    sget-boolean v0, Landroid/support/v4/widget/b;->a:Z

    if-eqz v0, :cond_0

    .line 331
    invoke-super {p0}, Landroid/widget/TextView;->getAutoSizeMinTextSize()I

    move-result v0

    return v0

    .line 333
    :cond_0
    iget-object v0, p0, Landroid/support/v7/widget/I;->b:Landroid/support/v7/widget/H;

    if-eqz v0, :cond_1

    .line 334
    invoke-virtual {v0}, Landroid/support/v7/widget/H;->d()I

    move-result v0

    return v0

    .line 337
    :cond_1
    const/4 v0, -0x1

    return v0
.end method

.method public getAutoSizeStepGranularity()I
    .locals 1

    .line 311
    sget-boolean v0, Landroid/support/v4/widget/b;->a:Z

    if-eqz v0, :cond_0

    .line 312
    invoke-super {p0}, Landroid/widget/TextView;->getAutoSizeStepGranularity()I

    move-result v0

    return v0

    .line 314
    :cond_0
    iget-object v0, p0, Landroid/support/v7/widget/I;->b:Landroid/support/v7/widget/H;

    if-eqz v0, :cond_1

    .line 315
    invoke-virtual {v0}, Landroid/support/v7/widget/H;->e()I

    move-result v0

    return v0

    .line 318
    :cond_1
    const/4 v0, -0x1

    return v0
.end method

.method public getAutoSizeTextAvailableSizes()[I
    .locals 1

    .line 368
    sget-boolean v0, Landroid/support/v4/widget/b;->a:Z

    if-eqz v0, :cond_0

    .line 369
    invoke-super {p0}, Landroid/widget/TextView;->getAutoSizeTextAvailableSizes()[I

    move-result-object v0

    return-object v0

    .line 371
    :cond_0
    iget-object v0, p0, Landroid/support/v7/widget/I;->b:Landroid/support/v7/widget/H;

    if-eqz v0, :cond_1

    .line 372
    invoke-virtual {v0}, Landroid/support/v7/widget/H;->f()[I

    move-result-object v0

    return-object v0

    .line 375
    :cond_1
    const/4 v0, 0x0

    new-array v0, v0, [I

    return-object v0
.end method

.method public getAutoSizeTextType()I
    .locals 3

    .line 290
    sget-boolean v0, Landroid/support/v4/widget/b;->a:Z

    const/4 v1, 0x0

    if-eqz v0, :cond_1

    .line 291
    invoke-super {p0}, Landroid/widget/TextView;->getAutoSizeTextType()I

    move-result v0

    const/4 v2, 0x1

    if-ne v0, v2, :cond_0

    const/4 v1, 0x1

    :cond_0
    return v1

    .line 295
    :cond_1
    iget-object v0, p0, Landroid/support/v7/widget/I;->b:Landroid/support/v7/widget/H;

    if-eqz v0, :cond_2

    .line 296
    invoke-virtual {v0}, Landroid/support/v7/widget/H;->g()I

    move-result v0

    return v0

    .line 299
    :cond_2
    return v1
.end method

.method public getFirstBaselineToTopHeight()I
    .locals 1

    .line 406
    invoke-static {p0}, Landroid/support/v4/widget/m;->a(Landroid/widget/TextView;)I

    move-result v0

    return v0
.end method

.method public getLastBaselineToBottomHeight()I
    .locals 1

    .line 411
    invoke-static {p0}, Landroid/support/v4/widget/m;->b(Landroid/widget/TextView;)I

    move-result v0

    return v0
.end method

.method public getSupportBackgroundTintList()Landroid/content/res/ColorStateList;
    .locals 1

    .line 137
    iget-object v0, p0, Landroid/support/v7/widget/I;->a:Landroid/support/v7/widget/j;

    if-eqz v0, :cond_0

    .line 138
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

    .line 165
    iget-object v0, p0, Landroid/support/v7/widget/I;->a:Landroid/support/v7/widget/j;

    if-eqz v0, :cond_0

    .line 166
    invoke-virtual {v0}, Landroid/support/v7/widget/j;->c()Landroid/graphics/PorterDuff$Mode;

    move-result-object v0

    goto :goto_0

    :cond_0
    const/4 v0, 0x0

    :goto_0
    return-object v0
.end method

.method public getText()Ljava/lang/CharSequence;
    .locals 1

    .line 477
    invoke-direct {p0}, Landroid/support/v7/widget/I;->d()V

    .line 478
    invoke-super {p0}, Landroid/widget/TextView;->getText()Ljava/lang/CharSequence;

    move-result-object v0

    return-object v0
.end method

.method public getTextMetricsParamsCompat()La/b/c/e/a$a;
    .locals 1

    .line 437
    invoke-static {p0}, Landroid/support/v4/widget/m;->c(Landroid/widget/TextView;)La/b/c/e/a$a;

    move-result-object v0

    return-object v0
.end method

.method public onCreateInputConnection(Landroid/view/inputmethod/EditorInfo;)Landroid/view/inputmethod/InputConnection;
    .locals 1
    .param p1, "outAttrs"    # Landroid/view/inputmethod/EditorInfo;

    .line 380
    invoke-super {p0, p1}, Landroid/widget/TextView;->onCreateInputConnection(Landroid/view/inputmethod/EditorInfo;)Landroid/view/inputmethod/InputConnection;

    move-result-object v0

    invoke-static {v0, p1, p0}, Landroid/support/v7/widget/q;->a(Landroid/view/inputmethod/InputConnection;Landroid/view/inputmethod/EditorInfo;Landroid/view/View;)Landroid/view/inputmethod/InputConnection;

    return-object v0
.end method

.method protected onLayout(ZIIII)V
    .locals 6
    .param p1, "changed"    # Z
    .param p2, "left"    # I
    .param p3, "top"    # I
    .param p4, "right"    # I
    .param p5, "bottom"    # I

    .line 190
    invoke-super/range {p0 .. p5}, Landroid/widget/TextView;->onLayout(ZIIII)V

    .line 191
    iget-object v0, p0, Landroid/support/v7/widget/I;->b:Landroid/support/v7/widget/H;

    if-eqz v0, :cond_0

    .line 192
    move v1, p1

    move v2, p2

    move v3, p3

    move v4, p4

    move v5, p5

    invoke-virtual/range {v0 .. v5}, Landroid/support/v7/widget/H;->a(ZIIII)V

    .line 194
    :cond_0
    return-void
.end method

.method protected onMeasure(II)V
    .locals 0
    .param p1, "widthMeasureSpec"    # I
    .param p2, "heightMeasureSpec"    # I

    .line 500
    invoke-direct {p0}, Landroid/support/v7/widget/I;->d()V

    .line 501
    invoke-super {p0, p1, p2}, Landroid/widget/TextView;->onMeasure(II)V

    .line 502
    return-void
.end method

.method protected onTextChanged(Ljava/lang/CharSequence;III)V
    .locals 2
    .param p1, "text"    # Ljava/lang/CharSequence;
    .param p2, "start"    # I
    .param p3, "lengthBefore"    # I
    .param p4, "lengthAfter"    # I

    .line 209
    invoke-super {p0, p1, p2, p3, p4}, Landroid/widget/TextView;->onTextChanged(Ljava/lang/CharSequence;III)V

    .line 210
    iget-object v0, p0, Landroid/support/v7/widget/I;->b:Landroid/support/v7/widget/H;

    if-eqz v0, :cond_0

    sget-boolean v1, Landroid/support/v4/widget/b;->a:Z

    if-nez v1, :cond_0

    invoke-virtual {v0}, Landroid/support/v7/widget/H;->h()Z

    move-result v0

    if-eqz v0, :cond_0

    .line 211
    iget-object v0, p0, Landroid/support/v7/widget/I;->b:Landroid/support/v7/widget/H;

    invoke-virtual {v0}, Landroid/support/v7/widget/H;->b()V

    .line 213
    :cond_0
    return-void
.end method

.method public setAutoSizeTextTypeUniformWithConfiguration(IIII)V
    .locals 1
    .param p1, "autoSizeMinTextSize"    # I
    .param p2, "autoSizeMaxTextSize"    # I
    .param p3, "autoSizeStepGranularity"    # I
    .param p4, "unit"    # I

    .line 249
    sget-boolean v0, Landroid/support/v4/widget/b;->a:Z

    if-eqz v0, :cond_0

    .line 250
    invoke-super {p0, p1, p2, p3, p4}, Landroid/widget/TextView;->setAutoSizeTextTypeUniformWithConfiguration(IIII)V

    goto :goto_0

    .line 253
    :cond_0
    iget-object v0, p0, Landroid/support/v7/widget/I;->b:Landroid/support/v7/widget/H;

    if-eqz v0, :cond_1

    .line 254
    invoke-virtual {v0, p1, p2, p3, p4}, Landroid/support/v7/widget/H;->a(IIII)V

    .line 258
    :cond_1
    :goto_0
    return-void
.end method

.method public setAutoSizeTextTypeUniformWithPresetSizes([II)V
    .locals 1
    .param p1, "presetSizes"    # [I
    .param p2, "unit"    # I

    .line 271
    sget-boolean v0, Landroid/support/v4/widget/b;->a:Z

    if-eqz v0, :cond_0

    .line 272
    invoke-super {p0, p1, p2}, Landroid/widget/TextView;->setAutoSizeTextTypeUniformWithPresetSizes([II)V

    goto :goto_0

    .line 274
    :cond_0
    iget-object v0, p0, Landroid/support/v7/widget/I;->b:Landroid/support/v7/widget/H;

    if-eqz v0, :cond_1

    .line 275
    invoke-virtual {v0, p1, p2}, Landroid/support/v7/widget/H;->a([II)V

    .line 278
    :cond_1
    :goto_0
    return-void
.end method

.method public setAutoSizeTextTypeWithDefaults(I)V
    .locals 1
    .param p1, "autoSizeTextType"    # I

    .line 226
    sget-boolean v0, Landroid/support/v4/widget/b;->a:Z

    if-eqz v0, :cond_0

    .line 227
    invoke-super {p0, p1}, Landroid/widget/TextView;->setAutoSizeTextTypeWithDefaults(I)V

    goto :goto_0

    .line 229
    :cond_0
    iget-object v0, p0, Landroid/support/v7/widget/I;->b:Landroid/support/v7/widget/H;

    if-eqz v0, :cond_1

    .line 230
    invoke-virtual {v0, p1}, Landroid/support/v7/widget/H;->a(I)V

    .line 233
    :cond_1
    :goto_0
    return-void
.end method

.method public setBackgroundDrawable(Landroid/graphics/drawable/Drawable;)V
    .locals 1
    .param p1, "background"    # Landroid/graphics/drawable/Drawable;

    .line 107
    invoke-super {p0, p1}, Landroid/widget/TextView;->setBackgroundDrawable(Landroid/graphics/drawable/Drawable;)V

    .line 108
    iget-object v0, p0, Landroid/support/v7/widget/I;->a:Landroid/support/v7/widget/j;

    if-eqz v0, :cond_0

    .line 109
    invoke-virtual {v0, p1}, Landroid/support/v7/widget/j;->a(Landroid/graphics/drawable/Drawable;)V

    .line 111
    :cond_0
    return-void
.end method

.method public setBackgroundResource(I)V
    .locals 1
    .param p1, "resId"    # I

    .line 99
    invoke-super {p0, p1}, Landroid/widget/TextView;->setBackgroundResource(I)V

    .line 100
    iget-object v0, p0, Landroid/support/v7/widget/I;->a:Landroid/support/v7/widget/j;

    if-eqz v0, :cond_0

    .line 101
    invoke-virtual {v0, p1}, Landroid/support/v7/widget/j;->a(I)V

    .line 103
    :cond_0
    return-void
.end method

.method public setCustomSelectionActionModeCallback(Landroid/view/ActionMode$Callback;)V
    .locals 1
    .param p1, "actionModeCallback"    # Landroid/view/ActionMode$Callback;

    .line 425
    nop

    .line 426
    invoke-static {p0, p1}, Landroid/support/v4/widget/m;->a(Landroid/widget/TextView;Landroid/view/ActionMode$Callback;)Landroid/view/ActionMode$Callback;

    move-result-object v0

    .line 425
    invoke-super {p0, v0}, Landroid/widget/TextView;->setCustomSelectionActionModeCallback(Landroid/view/ActionMode$Callback;)V

    .line 427
    return-void
.end method

.method public setFirstBaselineToTopHeight(I)V
    .locals 2
    .param p1, "firstBaselineToTopHeight"    # I

    .line 386
    sget v0, Landroid/os/Build$VERSION;->SDK_INT:I

    const/16 v1, 0x1c

    if-lt v0, v1, :cond_0

    .line 387
    invoke-super {p0, p1}, Landroid/widget/TextView;->setFirstBaselineToTopHeight(I)V

    goto :goto_0

    .line 389
    :cond_0
    invoke-static {p0, p1}, Landroid/support/v4/widget/m;->a(Landroid/widget/TextView;I)V

    .line 391
    :goto_0
    return-void
.end method

.method public setLastBaselineToBottomHeight(I)V
    .locals 2
    .param p1, "lastBaselineToBottomHeight"    # I

    .line 396
    sget v0, Landroid/os/Build$VERSION;->SDK_INT:I

    const/16 v1, 0x1c

    if-lt v0, v1, :cond_0

    .line 397
    invoke-super {p0, p1}, Landroid/widget/TextView;->setLastBaselineToBottomHeight(I)V

    goto :goto_0

    .line 399
    :cond_0
    invoke-static {p0, p1}, Landroid/support/v4/widget/m;->b(Landroid/widget/TextView;I)V

    .line 402
    :goto_0
    return-void
.end method

.method public setLineHeight(I)V
    .locals 0
    .param p1, "lineHeight"    # I

    .line 416
    invoke-static {p0, p1}, Landroid/support/v4/widget/m;->c(Landroid/widget/TextView;I)V

    .line 417
    return-void
.end method

.method public setPrecomputedText(La/b/c/e/a;)V
    .locals 0
    .param p1, "precomputed"    # La/b/c/e/a;

    .line 460
    invoke-static {p0, p1}, Landroid/support/v4/widget/m;->a(Landroid/widget/TextView;La/b/c/e/a;)V

    .line 461
    return-void
.end method

.method public setSupportBackgroundTintList(Landroid/content/res/ColorStateList;)V
    .locals 1
    .param p1, "tint"    # Landroid/content/res/ColorStateList;

    .line 122
    iget-object v0, p0, Landroid/support/v7/widget/I;->a:Landroid/support/v7/widget/j;

    if-eqz v0, :cond_0

    .line 123
    invoke-virtual {v0, p1}, Landroid/support/v7/widget/j;->b(Landroid/content/res/ColorStateList;)V

    .line 125
    :cond_0
    return-void
.end method

.method public setSupportBackgroundTintMode(Landroid/graphics/PorterDuff$Mode;)V
    .locals 1
    .param p1, "tintMode"    # Landroid/graphics/PorterDuff$Mode;

    .line 150
    iget-object v0, p0, Landroid/support/v7/widget/I;->a:Landroid/support/v7/widget/j;

    if-eqz v0, :cond_0

    .line 151
    invoke-virtual {v0, p1}, Landroid/support/v7/widget/j;->a(Landroid/graphics/PorterDuff$Mode;)V

    .line 153
    :cond_0
    return-void
.end method

.method public setTextAppearance(Landroid/content/Context;I)V
    .locals 1
    .param p1, "context"    # Landroid/content/Context;
    .param p2, "resId"    # I

    .line 171
    invoke-super {p0, p1, p2}, Landroid/widget/TextView;->setTextAppearance(Landroid/content/Context;I)V

    .line 172
    iget-object v0, p0, Landroid/support/v7/widget/I;->b:Landroid/support/v7/widget/H;

    if-eqz v0, :cond_0

    .line 173
    invoke-virtual {v0, p1, p2}, Landroid/support/v7/widget/H;->a(Landroid/content/Context;I)V

    .line 175
    :cond_0
    return-void
.end method

.method public setTextFuture(Ljava/util/concurrent/Future;)V
    .locals 0
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/util/concurrent/Future<",
            "La/b/c/e/a;",
            ">;)V"
        }
    .end annotation

    .line 494
    .local p1, "future":Ljava/util/concurrent/Future;, "Ljava/util/concurrent/Future<Landroid/support/v4/text/PrecomputedTextCompat;>;"
    iput-object p1, p0, Landroid/support/v7/widget/I;->c:Ljava/util/concurrent/Future;

    .line 495
    invoke-virtual {p0}, Landroid/widget/TextView;->requestLayout()V

    .line 496
    return-void
.end method

.method public setTextMetricsParamsCompat(La/b/c/e/a$a;)V
    .locals 0
    .param p1, "params"    # La/b/c/e/a$a;

    .line 447
    invoke-static {p0, p1}, Landroid/support/v4/widget/m;->a(Landroid/widget/TextView;La/b/c/e/a$a;)V

    .line 448
    return-void
.end method

.method public setTextSize(IF)V
    .locals 1
    .param p1, "unit"    # I
    .param p2, "size"    # F

    .line 198
    sget-boolean v0, Landroid/support/v4/widget/b;->a:Z

    if-eqz v0, :cond_0

    .line 199
    invoke-super {p0, p1, p2}, Landroid/widget/TextView;->setTextSize(IF)V

    goto :goto_0

    .line 201
    :cond_0
    iget-object v0, p0, Landroid/support/v7/widget/I;->b:Landroid/support/v7/widget/H;

    if-eqz v0, :cond_1

    .line 202
    invoke-virtual {v0, p1, p2}, Landroid/support/v7/widget/H;->a(IF)V

    .line 205
    :cond_1
    :goto_0
    return-void
.end method
