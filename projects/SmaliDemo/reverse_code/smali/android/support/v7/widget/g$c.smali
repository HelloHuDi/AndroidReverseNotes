.class Landroid/support/v7/widget/g$c;
.super Ljava/lang/Object;
.source ""

# interfaces
.implements Ljava/lang/Runnable;


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Landroid/support/v7/widget/g;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x2
    name = "c"
.end annotation


# instance fields
.field private a:Landroid/support/v7/widget/g$e;

.field final synthetic b:Landroid/support/v7/widget/g;


# direct methods
.method public constructor <init>(Landroid/support/v7/widget/g;Landroid/support/v7/widget/g$e;)V
    .locals 0
    .param p2, "popup"    # Landroid/support/v7/widget/g$e;

    .line 796
    iput-object p1, p0, Landroid/support/v7/widget/g$c;->b:Landroid/support/v7/widget/g;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 797
    iput-object p2, p0, Landroid/support/v7/widget/g$c;->a:Landroid/support/v7/widget/g$e;

    .line 798
    return-void
.end method


# virtual methods
.method public run()V
    .locals 3

    .line 802
    iget-object v0, p0, Landroid/support/v7/widget/g$c;->b:Landroid/support/v7/widget/g;

    invoke-static {v0}, Landroid/support/v7/widget/g;->d(Landroid/support/v7/widget/g;)Landroid/support/v7/view/menu/l;

    move-result-object v0

    if-eqz v0, :cond_0

    .line 803
    iget-object v0, p0, Landroid/support/v7/widget/g$c;->b:Landroid/support/v7/widget/g;

    invoke-static {v0}, Landroid/support/v7/widget/g;->e(Landroid/support/v7/widget/g;)Landroid/support/v7/view/menu/l;

    move-result-object v0

    invoke-virtual {v0}, Landroid/support/v7/view/menu/l;->a()V

    .line 805
    :cond_0
    iget-object v0, p0, Landroid/support/v7/widget/g$c;->b:Landroid/support/v7/widget/g;

    invoke-static {v0}, Landroid/support/v7/widget/g;->f(Landroid/support/v7/widget/g;)Landroid/support/v7/view/menu/w;

    move-result-object v0

    check-cast v0, Landroid/view/View;

    .line 806
    .local v0, "menuView":Landroid/view/View;
    if-eqz v0, :cond_1

    invoke-virtual {v0}, Landroid/view/View;->getWindowToken()Landroid/os/IBinder;

    move-result-object v1

    if-eqz v1, :cond_1

    iget-object v1, p0, Landroid/support/v7/widget/g$c;->a:Landroid/support/v7/widget/g$e;

    invoke-virtual {v1}, Landroid/support/v7/view/menu/u;->f()Z

    move-result v1

    if-eqz v1, :cond_1

    .line 807
    iget-object v1, p0, Landroid/support/v7/widget/g$c;->b:Landroid/support/v7/widget/g;

    iget-object v2, p0, Landroid/support/v7/widget/g$c;->a:Landroid/support/v7/widget/g$e;

    iput-object v2, v1, Landroid/support/v7/widget/g;->z:Landroid/support/v7/widget/g$e;

    .line 809
    :cond_1
    iget-object v1, p0, Landroid/support/v7/widget/g$c;->b:Landroid/support/v7/widget/g;

    const/4 v2, 0x0

    iput-object v2, v1, Landroid/support/v7/widget/g;->B:Landroid/support/v7/widget/g$c;

    .line 810
    return-void
.end method
