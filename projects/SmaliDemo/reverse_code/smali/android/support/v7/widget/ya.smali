.class Landroid/support/v7/widget/ya;
.super Ljava/lang/Object;
.source ""

# interfaces
.implements Landroid/view/View$OnClickListener;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Landroid/support/v7/widget/Aa;-><init>(Landroid/support/v7/widget/Toolbar;ZII)V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final a:Landroid/support/v7/view/menu/a;

.field final synthetic b:Landroid/support/v7/widget/Aa;


# direct methods
.method constructor <init>(Landroid/support/v7/widget/Aa;)V
    .locals 8
    .param p1, "this$0"    # Landroid/support/v7/widget/Aa;

    .line 182
    iput-object p1, p0, Landroid/support/v7/widget/ya;->b:Landroid/support/v7/widget/Aa;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 183
    new-instance v7, Landroid/support/v7/view/menu/a;

    iget-object v0, p0, Landroid/support/v7/widget/ya;->b:Landroid/support/v7/widget/Aa;

    iget-object v0, v0, Landroid/support/v7/widget/Aa;->a:Landroid/support/v7/widget/Toolbar;

    invoke-virtual {v0}, Landroid/view/ViewGroup;->getContext()Landroid/content/Context;

    move-result-object v1

    iget-object v0, p0, Landroid/support/v7/widget/ya;->b:Landroid/support/v7/widget/Aa;

    iget-object v6, v0, Landroid/support/v7/widget/Aa;->i:Ljava/lang/CharSequence;

    const/4 v2, 0x0

    const v3, 0x102002c

    const/4 v4, 0x0

    const/4 v5, 0x0

    move-object v0, v7

    invoke-direct/range {v0 .. v6}, Landroid/support/v7/view/menu/a;-><init>(Landroid/content/Context;IIIILjava/lang/CharSequence;)V

    iput-object v7, p0, Landroid/support/v7/widget/ya;->a:Landroid/support/v7/view/menu/a;

    return-void
.end method


# virtual methods
.method public onClick(Landroid/view/View;)V
    .locals 3
    .param p1, "v"    # Landroid/view/View;

    .line 187
    iget-object v0, p0, Landroid/support/v7/widget/ya;->b:Landroid/support/v7/widget/Aa;

    iget-object v1, v0, Landroid/support/v7/widget/Aa;->l:Landroid/view/Window$Callback;

    if-eqz v1, :cond_0

    iget-boolean v0, v0, Landroid/support/v7/widget/Aa;->m:Z

    if-eqz v0, :cond_0

    .line 188
    const/4 v0, 0x0

    iget-object v2, p0, Landroid/support/v7/widget/ya;->a:Landroid/support/v7/view/menu/a;

    invoke-interface {v1, v0, v2}, Landroid/view/Window$Callback;->onMenuItemSelected(ILandroid/view/MenuItem;)Z

    .line 190
    :cond_0
    return-void
.end method
