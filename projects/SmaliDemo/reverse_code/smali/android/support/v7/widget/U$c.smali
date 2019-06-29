.class Landroid/support/v7/widget/U$c;
.super Ljava/lang/Object;
.source ""

# interfaces
.implements Landroid/widget/AbsListView$OnScrollListener;


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Landroid/support/v7/widget/U;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x2
    name = "c"
.end annotation


# instance fields
.field final synthetic a:Landroid/support/v7/widget/U;


# direct methods
.method constructor <init>(Landroid/support/v7/widget/U;)V
    .locals 0

    .line 1387
    iput-object p1, p0, Landroid/support/v7/widget/U$c;->a:Landroid/support/v7/widget/U;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 1388
    return-void
.end method


# virtual methods
.method public onScroll(Landroid/widget/AbsListView;III)V
    .locals 0
    .param p1, "view"    # Landroid/widget/AbsListView;
    .param p2, "firstVisibleItem"    # I
    .param p3, "visibleItemCount"    # I
    .param p4, "totalItemCount"    # I

    .line 1394
    return-void
.end method

.method public onScrollStateChanged(Landroid/widget/AbsListView;I)V
    .locals 2
    .param p1, "view"    # Landroid/widget/AbsListView;
    .param p2, "scrollState"    # I

    .line 1398
    const/4 v0, 0x1

    if-ne p2, v0, :cond_0

    iget-object v0, p0, Landroid/support/v7/widget/U$c;->a:Landroid/support/v7/widget/U;

    .line 1399
    invoke-virtual {v0}, Landroid/support/v7/widget/U;->j()Z

    move-result v0

    if-nez v0, :cond_0

    iget-object v0, p0, Landroid/support/v7/widget/U$c;->a:Landroid/support/v7/widget/U;

    iget-object v0, v0, Landroid/support/v7/widget/U;->J:Landroid/widget/PopupWindow;

    invoke-virtual {v0}, Landroid/widget/PopupWindow;->getContentView()Landroid/view/View;

    move-result-object v0

    if-eqz v0, :cond_0

    .line 1400
    iget-object v0, p0, Landroid/support/v7/widget/U$c;->a:Landroid/support/v7/widget/U;

    iget-object v1, v0, Landroid/support/v7/widget/U;->F:Landroid/os/Handler;

    iget-object v0, v0, Landroid/support/v7/widget/U;->A:Landroid/support/v7/widget/U$e;

    invoke-virtual {v1, v0}, Landroid/os/Handler;->removeCallbacks(Ljava/lang/Runnable;)V

    .line 1401
    iget-object v0, p0, Landroid/support/v7/widget/U$c;->a:Landroid/support/v7/widget/U;

    iget-object v0, v0, Landroid/support/v7/widget/U;->A:Landroid/support/v7/widget/U$e;

    invoke-virtual {v0}, Landroid/support/v7/widget/U$e;->run()V

    .line 1403
    :cond_0
    return-void
.end method
