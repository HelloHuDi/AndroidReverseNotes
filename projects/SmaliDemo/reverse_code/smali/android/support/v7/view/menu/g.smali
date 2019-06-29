.class Landroid/support/v7/view/menu/g;
.super Ljava/lang/Object;
.source ""

# interfaces
.implements Ljava/lang/Runnable;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Landroid/support/v7/view/menu/h;->a(Landroid/support/v7/view/menu/l;Landroid/view/MenuItem;)V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic a:Landroid/support/v7/view/menu/i$a;

.field final synthetic b:Landroid/view/MenuItem;

.field final synthetic c:Landroid/support/v7/view/menu/l;

.field final synthetic d:Landroid/support/v7/view/menu/h;


# direct methods
.method constructor <init>(Landroid/support/v7/view/menu/h;Landroid/support/v7/view/menu/i$a;Landroid/view/MenuItem;Landroid/support/v7/view/menu/l;)V
    .locals 0
    .param p1, "this$1"    # Landroid/support/v7/view/menu/h;

    .line 173
    iput-object p1, p0, Landroid/support/v7/view/menu/g;->d:Landroid/support/v7/view/menu/h;

    iput-object p2, p0, Landroid/support/v7/view/menu/g;->a:Landroid/support/v7/view/menu/i$a;

    iput-object p3, p0, Landroid/support/v7/view/menu/g;->b:Landroid/view/MenuItem;

    iput-object p4, p0, Landroid/support/v7/view/menu/g;->c:Landroid/support/v7/view/menu/l;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public run()V
    .locals 3

    .line 178
    iget-object v0, p0, Landroid/support/v7/view/menu/g;->a:Landroid/support/v7/view/menu/i$a;

    if-eqz v0, :cond_0

    .line 181
    iget-object v1, p0, Landroid/support/v7/view/menu/g;->d:Landroid/support/v7/view/menu/h;

    iget-object v1, v1, Landroid/support/v7/view/menu/h;->a:Landroid/support/v7/view/menu/i;

    const/4 v2, 0x1

    iput-boolean v2, v1, Landroid/support/v7/view/menu/i;->B:Z

    .line 182
    iget-object v0, v0, Landroid/support/v7/view/menu/i$a;->b:Landroid/support/v7/view/menu/l;

    const/4 v1, 0x0

    invoke-virtual {v0, v1}, Landroid/support/v7/view/menu/l;->a(Z)V

    .line 183
    iget-object v0, p0, Landroid/support/v7/view/menu/g;->d:Landroid/support/v7/view/menu/h;

    iget-object v0, v0, Landroid/support/v7/view/menu/h;->a:Landroid/support/v7/view/menu/i;

    iput-boolean v1, v0, Landroid/support/v7/view/menu/i;->B:Z

    .line 187
    :cond_0
    iget-object v0, p0, Landroid/support/v7/view/menu/g;->b:Landroid/view/MenuItem;

    invoke-interface {v0}, Landroid/view/MenuItem;->isEnabled()Z

    move-result v0

    if-eqz v0, :cond_1

    iget-object v0, p0, Landroid/support/v7/view/menu/g;->b:Landroid/view/MenuItem;

    invoke-interface {v0}, Landroid/view/MenuItem;->hasSubMenu()Z

    move-result v0

    if-eqz v0, :cond_1

    .line 188
    iget-object v0, p0, Landroid/support/v7/view/menu/g;->c:Landroid/support/v7/view/menu/l;

    iget-object v1, p0, Landroid/support/v7/view/menu/g;->b:Landroid/view/MenuItem;

    const/4 v2, 0x4

    invoke-virtual {v0, v1, v2}, Landroid/support/v7/view/menu/l;->a(Landroid/view/MenuItem;I)Z

    .line 190
    :cond_1
    return-void
.end method
