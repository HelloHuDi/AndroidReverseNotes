.class Landroid/support/v7/widget/N$a;
.super La/b/d/c/a/e;
.source ""


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Landroid/support/v7/widget/N;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0xa
    name = "a"
.end annotation


# instance fields
.field private b:Z


# direct methods
.method constructor <init>(Landroid/graphics/drawable/Drawable;)V
    .locals 1
    .param p1, "drawable"    # Landroid/graphics/drawable/Drawable;

    .line 382
    invoke-direct {p0, p1}, La/b/d/c/a/e;-><init>(Landroid/graphics/drawable/Drawable;)V

    .line 383
    const/4 v0, 0x1

    iput-boolean v0, p0, Landroid/support/v7/widget/N$a;->b:Z

    .line 384
    return-void
.end method


# virtual methods
.method a(Z)V
    .locals 0
    .param p1, "enabled"    # Z

    .line 387
    iput-boolean p1, p0, Landroid/support/v7/widget/N$a;->b:Z

    .line 388
    return-void
.end method

.method public draw(Landroid/graphics/Canvas;)V
    .locals 1
    .param p1, "canvas"    # Landroid/graphics/Canvas;

    .line 400
    iget-boolean v0, p0, Landroid/support/v7/widget/N$a;->b:Z

    if-eqz v0, :cond_0

    .line 401
    invoke-super {p0, p1}, La/b/d/c/a/e;->draw(Landroid/graphics/Canvas;)V

    .line 403
    :cond_0
    return-void
.end method

.method public setHotspot(FF)V
    .locals 1
    .param p1, "x"    # F
    .param p2, "y"    # F

    .line 407
    iget-boolean v0, p0, Landroid/support/v7/widget/N$a;->b:Z

    if-eqz v0, :cond_0

    .line 408
    invoke-super {p0, p1, p2}, La/b/d/c/a/e;->setHotspot(FF)V

    .line 410
    :cond_0
    return-void
.end method

.method public setHotspotBounds(IIII)V
    .locals 1
    .param p1, "left"    # I
    .param p2, "top"    # I
    .param p3, "right"    # I
    .param p4, "bottom"    # I

    .line 414
    iget-boolean v0, p0, Landroid/support/v7/widget/N$a;->b:Z

    if-eqz v0, :cond_0

    .line 415
    invoke-super {p0, p1, p2, p3, p4}, La/b/d/c/a/e;->setHotspotBounds(IIII)V

    .line 417
    :cond_0
    return-void
.end method

.method public setState([I)Z
    .locals 1
    .param p1, "stateSet"    # [I

    .line 392
    iget-boolean v0, p0, Landroid/support/v7/widget/N$a;->b:Z

    if-eqz v0, :cond_0

    .line 393
    invoke-super {p0, p1}, La/b/d/c/a/e;->setState([I)Z

    move-result v0

    return v0

    .line 395
    :cond_0
    const/4 v0, 0x0

    return v0
.end method

.method public setVisible(ZZ)Z
    .locals 1
    .param p1, "visible"    # Z
    .param p2, "restart"    # Z

    .line 421
    iget-boolean v0, p0, Landroid/support/v7/widget/N$a;->b:Z

    if-eqz v0, :cond_0

    .line 422
    invoke-super {p0, p1, p2}, La/b/d/c/a/e;->setVisible(ZZ)Z

    move-result v0

    return v0

    .line 424
    :cond_0
    const/4 v0, 0x0

    return v0
.end method
