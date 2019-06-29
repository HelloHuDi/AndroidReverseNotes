.class public Landroid/support/v7/app/a$a;
.super Landroid/view/ViewGroup$MarginLayoutParams;
.source ""


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Landroid/support/v7/app/a;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "a"
.end annotation


# instance fields
.field public a:I


# direct methods
.method public constructor <init>(II)V
    .locals 1
    .param p1, "width"    # I
    .param p2, "height"    # I

    .line 1385
    invoke-direct {p0, p1, p2}, Landroid/view/ViewGroup$MarginLayoutParams;-><init>(II)V

    .line 1374
    const/4 v0, 0x0

    iput v0, p0, Landroid/support/v7/app/a$a;->a:I

    .line 1386
    const v0, 0x800013

    iput v0, p0, Landroid/support/v7/app/a$a;->a:I

    .line 1387
    return-void
.end method

.method public constructor <init>(Landroid/content/Context;Landroid/util/AttributeSet;)V
    .locals 3
    .param p1, "c"    # Landroid/content/Context;
    .param p2, "attrs"    # Landroid/util/AttributeSet;

    .line 1377
    invoke-direct {p0, p1, p2}, Landroid/view/ViewGroup$MarginLayoutParams;-><init>(Landroid/content/Context;Landroid/util/AttributeSet;)V

    .line 1374
    const/4 v0, 0x0

    iput v0, p0, Landroid/support/v7/app/a$a;->a:I

    .line 1379
    sget-object v1, La/b/d/a/j;->ActionBarLayout:[I

    invoke-virtual {p1, p2, v1}, Landroid/content/Context;->obtainStyledAttributes(Landroid/util/AttributeSet;[I)Landroid/content/res/TypedArray;

    move-result-object v1

    .line 1380
    .local v1, "a":Landroid/content/res/TypedArray;
    sget v2, La/b/d/a/j;->ActionBarLayout_android_layout_gravity:I

    invoke-virtual {v1, v2, v0}, Landroid/content/res/TypedArray;->getInt(II)I

    move-result v0

    iput v0, p0, Landroid/support/v7/app/a$a;->a:I

    .line 1381
    invoke-virtual {v1}, Landroid/content/res/TypedArray;->recycle()V

    .line 1382
    return-void
.end method

.method public constructor <init>(Landroid/support/v7/app/a$a;)V
    .locals 1
    .param p1, "source"    # Landroid/support/v7/app/a$a;

    .line 1399
    invoke-direct {p0, p1}, Landroid/view/ViewGroup$MarginLayoutParams;-><init>(Landroid/view/ViewGroup$MarginLayoutParams;)V

    .line 1374
    const/4 v0, 0x0

    iput v0, p0, Landroid/support/v7/app/a$a;->a:I

    .line 1401
    iget v0, p1, Landroid/support/v7/app/a$a;->a:I

    iput v0, p0, Landroid/support/v7/app/a$a;->a:I

    .line 1402
    return-void
.end method

.method public constructor <init>(Landroid/view/ViewGroup$LayoutParams;)V
    .locals 1
    .param p1, "source"    # Landroid/view/ViewGroup$LayoutParams;

    .line 1405
    invoke-direct {p0, p1}, Landroid/view/ViewGroup$MarginLayoutParams;-><init>(Landroid/view/ViewGroup$LayoutParams;)V

    .line 1374
    const/4 v0, 0x0

    iput v0, p0, Landroid/support/v7/app/a$a;->a:I

    .line 1406
    return-void
.end method
