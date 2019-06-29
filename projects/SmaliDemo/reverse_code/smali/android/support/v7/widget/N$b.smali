.class Landroid/support/v7/widget/N$b;
.super Ljava/lang/Object;
.source ""

# interfaces
.implements Ljava/lang/Runnable;


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Landroid/support/v7/widget/N;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x2
    name = "b"
.end annotation


# instance fields
.field final synthetic a:Landroid/support/v7/widget/N;


# direct methods
.method constructor <init>(Landroid/support/v7/widget/N;)V
    .locals 0

    .line 700
    iput-object p1, p0, Landroid/support/v7/widget/N$b;->a:Landroid/support/v7/widget/N;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 701
    return-void
.end method


# virtual methods
.method public a()V
    .locals 2

    .line 711
    iget-object v0, p0, Landroid/support/v7/widget/N$b;->a:Landroid/support/v7/widget/N;

    const/4 v1, 0x0

    iput-object v1, v0, Landroid/support/v7/widget/N;->n:Landroid/support/v7/widget/N$b;

    .line 712
    invoke-virtual {v0, p0}, Landroid/widget/ListView;->removeCallbacks(Ljava/lang/Runnable;)Z

    .line 713
    return-void
.end method

.method public b()V
    .locals 1

    .line 716
    iget-object v0, p0, Landroid/support/v7/widget/N$b;->a:Landroid/support/v7/widget/N;

    invoke-virtual {v0, p0}, Landroid/widget/ListView;->post(Ljava/lang/Runnable;)Z

    .line 717
    return-void
.end method

.method public run()V
    .locals 2

    .line 706
    iget-object v0, p0, Landroid/support/v7/widget/N$b;->a:Landroid/support/v7/widget/N;

    const/4 v1, 0x0

    iput-object v1, v0, Landroid/support/v7/widget/N;->n:Landroid/support/v7/widget/N$b;

    .line 707
    invoke-virtual {v0}, Landroid/support/v7/widget/N;->drawableStateChanged()V

    .line 708
    return-void
.end method
