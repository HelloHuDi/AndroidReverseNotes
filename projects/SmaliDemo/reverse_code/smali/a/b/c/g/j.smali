.class public final La/b/c/g/j;
.super Ljava/lang/Object;
.source ""


# direct methods
.method public static a(Landroid/view/MenuItem;La/b/c/g/e;)Landroid/view/MenuItem;
    .locals 2
    .param p0, "item"    # Landroid/view/MenuItem;
    .param p1, "provider"    # La/b/c/g/e;

    .line 207
    instance-of v0, p0, La/b/c/c/a/b;

    if-eqz v0, :cond_0

    .line 208
    move-object v0, p0

    check-cast v0, La/b/c/c/a/b;

    invoke-interface {v0, p1}, La/b/c/c/a/b;->a(La/b/c/g/e;)La/b/c/c/a/b;

    move-result-object v0

    return-object v0

    .line 211
    :cond_0
    const-string v0, "MenuItemCompat"

    const-string v1, "setActionProvider: item does not implement SupportMenuItem; ignoring"

    invoke-static {v0, v1}, Landroid/util/Log;->w(Ljava/lang/String;Ljava/lang/String;)I

    .line 212
    return-object p0
.end method

.method public static a(Landroid/view/MenuItem;CI)V
    .locals 2
    .param p0, "item"    # Landroid/view/MenuItem;
    .param p1, "alphaChar"    # C
    .param p2, "alphaModifiers"    # I

    .line 463
    instance-of v0, p0, La/b/c/c/a/b;

    if-eqz v0, :cond_0

    .line 464
    move-object v0, p0

    check-cast v0, La/b/c/c/a/b;

    invoke-interface {v0, p1, p2}, La/b/c/c/a/b;->setAlphabeticShortcut(CI)Landroid/view/MenuItem;

    goto :goto_0

    .line 465
    :cond_0
    sget v0, Landroid/os/Build$VERSION;->SDK_INT:I

    const/16 v1, 0x1a

    if-lt v0, v1, :cond_1

    .line 466
    invoke-interface {p0, p1, p2}, Landroid/view/MenuItem;->setAlphabeticShortcut(CI)Landroid/view/MenuItem;

    .line 468
    :cond_1
    :goto_0
    return-void
.end method

.method public static a(Landroid/view/MenuItem;Landroid/content/res/ColorStateList;)V
    .locals 2
    .param p0, "item"    # Landroid/view/MenuItem;
    .param p1, "tint"    # Landroid/content/res/ColorStateList;

    .line 503
    instance-of v0, p0, La/b/c/c/a/b;

    if-eqz v0, :cond_0

    .line 504
    move-object v0, p0

    check-cast v0, La/b/c/c/a/b;

    invoke-interface {v0, p1}, La/b/c/c/a/b;->setIconTintList(Landroid/content/res/ColorStateList;)Landroid/view/MenuItem;

    goto :goto_0

    .line 505
    :cond_0
    sget v0, Landroid/os/Build$VERSION;->SDK_INT:I

    const/16 v1, 0x1a

    if-lt v0, v1, :cond_1

    .line 506
    invoke-interface {p0, p1}, Landroid/view/MenuItem;->setIconTintList(Landroid/content/res/ColorStateList;)Landroid/view/MenuItem;

    .line 508
    :cond_1
    :goto_0
    return-void
.end method

.method public static a(Landroid/view/MenuItem;Landroid/graphics/PorterDuff$Mode;)V
    .locals 2
    .param p0, "item"    # Landroid/view/MenuItem;
    .param p1, "tintMode"    # Landroid/graphics/PorterDuff$Mode;

    .line 534
    instance-of v0, p0, La/b/c/c/a/b;

    if-eqz v0, :cond_0

    .line 535
    move-object v0, p0

    check-cast v0, La/b/c/c/a/b;

    invoke-interface {v0, p1}, La/b/c/c/a/b;->setIconTintMode(Landroid/graphics/PorterDuff$Mode;)Landroid/view/MenuItem;

    goto :goto_0

    .line 536
    :cond_0
    sget v0, Landroid/os/Build$VERSION;->SDK_INT:I

    const/16 v1, 0x1a

    if-lt v0, v1, :cond_1

    .line 537
    invoke-interface {p0, p1}, Landroid/view/MenuItem;->setIconTintMode(Landroid/graphics/PorterDuff$Mode;)Landroid/view/MenuItem;

    .line 539
    :cond_1
    :goto_0
    return-void
.end method

.method public static a(Landroid/view/MenuItem;Ljava/lang/CharSequence;)V
    .locals 2
    .param p0, "item"    # Landroid/view/MenuItem;
    .param p1, "contentDescription"    # Ljava/lang/CharSequence;

    .line 322
    instance-of v0, p0, La/b/c/c/a/b;

    if-eqz v0, :cond_0

    .line 323
    move-object v0, p0

    check-cast v0, La/b/c/c/a/b;

    invoke-interface {v0, p1}, La/b/c/c/a/b;->setContentDescription(Ljava/lang/CharSequence;)La/b/c/c/a/b;

    goto :goto_0

    .line 324
    :cond_0
    sget v0, Landroid/os/Build$VERSION;->SDK_INT:I

    const/16 v1, 0x1a

    if-lt v0, v1, :cond_1

    .line 325
    invoke-interface {p0, p1}, Landroid/view/MenuItem;->setContentDescription(Ljava/lang/CharSequence;)Landroid/view/MenuItem;

    .line 327
    :cond_1
    :goto_0
    return-void
.end method

.method public static b(Landroid/view/MenuItem;CI)V
    .locals 2
    .param p0, "item"    # Landroid/view/MenuItem;
    .param p1, "numericChar"    # C
    .param p2, "numericModifiers"    # I

    .line 418
    instance-of v0, p0, La/b/c/c/a/b;

    if-eqz v0, :cond_0

    .line 419
    move-object v0, p0

    check-cast v0, La/b/c/c/a/b;

    invoke-interface {v0, p1, p2}, La/b/c/c/a/b;->setNumericShortcut(CI)Landroid/view/MenuItem;

    goto :goto_0

    .line 420
    :cond_0
    sget v0, Landroid/os/Build$VERSION;->SDK_INT:I

    const/16 v1, 0x1a

    if-lt v0, v1, :cond_1

    .line 421
    invoke-interface {p0, p1, p2}, Landroid/view/MenuItem;->setNumericShortcut(CI)Landroid/view/MenuItem;

    .line 423
    :cond_1
    :goto_0
    return-void
.end method

.method public static b(Landroid/view/MenuItem;Ljava/lang/CharSequence;)V
    .locals 2
    .param p0, "item"    # Landroid/view/MenuItem;
    .param p1, "tooltipText"    # Ljava/lang/CharSequence;

    .line 351
    instance-of v0, p0, La/b/c/c/a/b;

    if-eqz v0, :cond_0

    .line 352
    move-object v0, p0

    check-cast v0, La/b/c/c/a/b;

    invoke-interface {v0, p1}, La/b/c/c/a/b;->setTooltipText(Ljava/lang/CharSequence;)La/b/c/c/a/b;

    goto :goto_0

    .line 353
    :cond_0
    sget v0, Landroid/os/Build$VERSION;->SDK_INT:I

    const/16 v1, 0x1a

    if-lt v0, v1, :cond_1

    .line 354
    invoke-interface {p0, p1}, Landroid/view/MenuItem;->setTooltipText(Ljava/lang/CharSequence;)Landroid/view/MenuItem;

    .line 356
    :cond_1
    :goto_0
    return-void
.end method
