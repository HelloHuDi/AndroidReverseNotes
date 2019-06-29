.class Landroid/support/v7/widget/Z;
.super Ljava/lang/Object;
.source ""

# interfaces
.implements Ljava/lang/Runnable;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Landroid/support/v7/widget/aa;->a(I)V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic a:Landroid/view/View;

.field final synthetic b:Landroid/support/v7/widget/aa;


# direct methods
.method constructor <init>(Landroid/support/v7/widget/aa;Landroid/view/View;)V
    .locals 0
    .param p1, "this$0"    # Landroid/support/v7/widget/aa;

    .line 264
    iput-object p1, p0, Landroid/support/v7/widget/Z;->b:Landroid/support/v7/widget/aa;

    iput-object p2, p0, Landroid/support/v7/widget/Z;->a:Landroid/view/View;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public run()V
    .locals 3

    .line 267
    iget-object v0, p0, Landroid/support/v7/widget/Z;->a:Landroid/view/View;

    invoke-virtual {v0}, Landroid/view/View;->getLeft()I

    move-result v0

    iget-object v1, p0, Landroid/support/v7/widget/Z;->b:Landroid/support/v7/widget/aa;

    invoke-virtual {v1}, Landroid/widget/HorizontalScrollView;->getWidth()I

    move-result v1

    iget-object v2, p0, Landroid/support/v7/widget/Z;->a:Landroid/view/View;

    invoke-virtual {v2}, Landroid/view/View;->getWidth()I

    move-result v2

    sub-int/2addr v1, v2

    div-int/lit8 v1, v1, 0x2

    sub-int/2addr v0, v1

    .line 268
    .local v0, "scrollPos":I
    iget-object v1, p0, Landroid/support/v7/widget/Z;->b:Landroid/support/v7/widget/aa;

    const/4 v2, 0x0

    invoke-virtual {v1, v0, v2}, Landroid/widget/HorizontalScrollView;->smoothScrollTo(II)V

    .line 269
    iget-object v1, p0, Landroid/support/v7/widget/Z;->b:Landroid/support/v7/widget/aa;

    const/4 v2, 0x0

    iput-object v2, v1, Landroid/support/v7/widget/aa;->b:Ljava/lang/Runnable;

    .line 270
    return-void
.end method
