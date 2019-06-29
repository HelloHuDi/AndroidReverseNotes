.class Landroid/support/v4/app/h;
.super Ljava/lang/Object;
.source ""

# interfaces
.implements Landroid/arch/lifecycle/f;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Landroid/support/v4/app/i;->b(Landroid/view/LayoutInflater;Landroid/view/ViewGroup;Landroid/os/Bundle;)V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic a:Landroid/support/v4/app/i;


# direct methods
.method constructor <init>(Landroid/support/v4/app/i;)V
    .locals 0
    .param p1, "this$0"    # Landroid/support/v4/app/i;

    .line 2429
    iput-object p1, p0, Landroid/support/v4/app/h;->a:Landroid/support/v4/app/i;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public a()Landroid/arch/lifecycle/d;
    .locals 3

    .line 2432
    iget-object v0, p0, Landroid/support/v4/app/h;->a:Landroid/support/v4/app/i;

    iget-object v1, v0, Landroid/support/v4/app/i;->V:Landroid/arch/lifecycle/h;

    if-nez v1, :cond_0

    .line 2433
    new-instance v1, Landroid/arch/lifecycle/h;

    iget-object v2, v0, Landroid/support/v4/app/i;->W:Landroid/arch/lifecycle/f;

    invoke-direct {v1, v2}, Landroid/arch/lifecycle/h;-><init>(Landroid/arch/lifecycle/f;)V

    iput-object v1, v0, Landroid/support/v4/app/i;->V:Landroid/arch/lifecycle/h;

    .line 2435
    :cond_0
    iget-object v0, p0, Landroid/support/v4/app/h;->a:Landroid/support/v4/app/i;

    iget-object v0, v0, Landroid/support/v4/app/i;->V:Landroid/arch/lifecycle/h;

    return-object v0
.end method
