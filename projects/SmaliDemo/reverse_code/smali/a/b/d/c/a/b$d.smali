.class La/b/d/c/a/b$d;
.super La/b/d/c/a/b$f;
.source ""


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = La/b/d/c/a/b;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0xa
    name = "d"
.end annotation


# instance fields
.field private final a:Landroid/animation/ObjectAnimator;

.field private final b:Z


# direct methods
.method constructor <init>(Landroid/graphics/drawable/AnimationDrawable;ZZ)V
    .locals 8
    .param p1, "ad"    # Landroid/graphics/drawable/AnimationDrawable;
    .param p2, "reversed"    # Z
    .param p3, "hasReversibleFlag"    # Z

    .line 391
    const/4 v0, 0x0

    invoke-direct {p0, v0}, La/b/d/c/a/b$f;-><init>(La/b/d/c/a/a;)V

    .line 392
    invoke-virtual {p1}, Landroid/graphics/drawable/AnimationDrawable;->getNumberOfFrames()I

    move-result v0

    .line 393
    .local v0, "frameCount":I
    const/4 v1, 0x0

    if-eqz p2, :cond_0

    add-int/lit8 v2, v0, -0x1

    goto :goto_0

    :cond_0
    const/4 v2, 0x0

    .line 394
    .local v2, "fromFrame":I
    :goto_0
    if-eqz p2, :cond_1

    const/4 v3, 0x0

    goto :goto_1

    :cond_1
    add-int/lit8 v3, v0, -0x1

    .line 395
    .local v3, "toFrame":I
    :goto_1
    new-instance v4, La/b/d/c/a/b$e;

    invoke-direct {v4, p1, p2}, La/b/d/c/a/b$e;-><init>(Landroid/graphics/drawable/AnimationDrawable;Z)V

    .line 397
    .local v4, "interp":La/b/d/c/a/b$e;
    const/4 v5, 0x2

    new-array v5, v5, [I

    aput v2, v5, v1

    const/4 v1, 0x1

    aput v3, v5, v1

    .line 398
    const-string v6, "currentIndex"

    invoke-static {p1, v6, v5}, Landroid/animation/ObjectAnimator;->ofInt(Ljava/lang/Object;Ljava/lang/String;[I)Landroid/animation/ObjectAnimator;

    move-result-object v5

    .line 399
    .local v5, "anim":Landroid/animation/ObjectAnimator;
    sget v6, Landroid/os/Build$VERSION;->SDK_INT:I

    const/16 v7, 0x12

    if-lt v6, v7, :cond_2

    .line 400
    invoke-virtual {v5, v1}, Landroid/animation/ObjectAnimator;->setAutoCancel(Z)V

    .line 402
    :cond_2
    invoke-virtual {v4}, La/b/d/c/a/b$e;->a()I

    move-result v1

    int-to-long v6, v1

    invoke-virtual {v5, v6, v7}, Landroid/animation/ObjectAnimator;->setDuration(J)Landroid/animation/ObjectAnimator;

    .line 403
    invoke-virtual {v5, v4}, Landroid/animation/ObjectAnimator;->setInterpolator(Landroid/animation/TimeInterpolator;)V

    .line 404
    iput-boolean p3, p0, La/b/d/c/a/b$d;->b:Z

    .line 405
    iput-object v5, p0, La/b/d/c/a/b$d;->a:Landroid/animation/ObjectAnimator;

    .line 406
    return-void
.end method


# virtual methods
.method public a()Z
    .locals 1

    .line 410
    iget-boolean v0, p0, La/b/d/c/a/b$d;->b:Z

    return v0
.end method

.method public b()V
    .locals 1

    .line 420
    iget-object v0, p0, La/b/d/c/a/b$d;->a:Landroid/animation/ObjectAnimator;

    invoke-virtual {v0}, Landroid/animation/ObjectAnimator;->reverse()V

    .line 421
    return-void
.end method

.method public c()V
    .locals 1

    .line 415
    iget-object v0, p0, La/b/d/c/a/b$d;->a:Landroid/animation/ObjectAnimator;

    invoke-virtual {v0}, Landroid/animation/ObjectAnimator;->start()V

    .line 416
    return-void
.end method

.method public d()V
    .locals 1

    .line 425
    iget-object v0, p0, La/b/d/c/a/b$d;->a:Landroid/animation/ObjectAnimator;

    invoke-virtual {v0}, Landroid/animation/ObjectAnimator;->cancel()V

    .line 426
    return-void
.end method
