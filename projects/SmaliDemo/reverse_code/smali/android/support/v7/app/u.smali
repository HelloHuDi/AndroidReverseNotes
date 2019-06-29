.class Landroid/support/v7/app/u;
.super La/b/c/g/C;
.source ""


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Landroid/support/v7/app/v;->run()V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic a:Landroid/support/v7/app/v;


# direct methods
.method constructor <init>(Landroid/support/v7/app/v;)V
    .locals 0
    .param p1, "this$1"    # Landroid/support/v7/app/v;

    .line 1002
    iput-object p1, p0, Landroid/support/v7/app/u;->a:Landroid/support/v7/app/v;

    invoke-direct {p0}, La/b/c/g/C;-><init>()V

    return-void
.end method


# virtual methods
.method public b(Landroid/view/View;)V
    .locals 2
    .param p1, "view"    # Landroid/view/View;

    .line 1010
    iget-object v0, p0, Landroid/support/v7/app/u;->a:Landroid/support/v7/app/v;

    iget-object v0, v0, Landroid/support/v7/app/v;->a:Landroid/support/v7/app/x;

    iget-object v0, v0, Landroid/support/v7/app/x;->q:Landroid/support/v7/widget/ActionBarContextView;

    const/high16 v1, 0x3f800000    # 1.0f

    invoke-virtual {v0, v1}, Landroid/view/ViewGroup;->setAlpha(F)V

    .line 1011
    iget-object v0, p0, Landroid/support/v7/app/u;->a:Landroid/support/v7/app/v;

    iget-object v0, v0, Landroid/support/v7/app/v;->a:Landroid/support/v7/app/x;

    iget-object v0, v0, Landroid/support/v7/app/x;->t:La/b/c/g/A;

    const/4 v1, 0x0

    invoke-virtual {v0, v1}, La/b/c/g/A;->a(La/b/c/g/B;)La/b/c/g/A;

    .line 1012
    iget-object v0, p0, Landroid/support/v7/app/u;->a:Landroid/support/v7/app/v;

    iget-object v0, v0, Landroid/support/v7/app/v;->a:Landroid/support/v7/app/x;

    iput-object v1, v0, Landroid/support/v7/app/x;->t:La/b/c/g/A;

    .line 1013
    return-void
.end method

.method public c(Landroid/view/View;)V
    .locals 2
    .param p1, "view"    # Landroid/view/View;

    .line 1005
    iget-object v0, p0, Landroid/support/v7/app/u;->a:Landroid/support/v7/app/v;

    iget-object v0, v0, Landroid/support/v7/app/v;->a:Landroid/support/v7/app/x;

    iget-object v0, v0, Landroid/support/v7/app/x;->q:Landroid/support/v7/widget/ActionBarContextView;

    const/4 v1, 0x0

    invoke-virtual {v0, v1}, Landroid/support/v7/widget/ActionBarContextView;->setVisibility(I)V

    .line 1006
    return-void
.end method
