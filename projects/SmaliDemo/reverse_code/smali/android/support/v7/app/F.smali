.class Landroid/support/v7/app/F;
.super La/b/c/g/C;
.source ""


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Landroid/support/v7/app/I;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic a:Landroid/support/v7/app/I;


# direct methods
.method constructor <init>(Landroid/support/v7/app/I;)V
    .locals 0
    .param p1, "this$0"    # Landroid/support/v7/app/I;

    .line 135
    iput-object p1, p0, Landroid/support/v7/app/F;->a:Landroid/support/v7/app/I;

    invoke-direct {p0}, La/b/c/g/C;-><init>()V

    return-void
.end method


# virtual methods
.method public b(Landroid/view/View;)V
    .locals 2
    .param p1, "view"    # Landroid/view/View;

    .line 138
    iget-object v0, p0, Landroid/support/v7/app/F;->a:Landroid/support/v7/app/I;

    iget-boolean v1, v0, Landroid/support/v7/app/I;->w:Z

    if-eqz v1, :cond_0

    iget-object v0, v0, Landroid/support/v7/app/I;->k:Landroid/view/View;

    if-eqz v0, :cond_0

    .line 139
    const/4 v1, 0x0

    invoke-virtual {v0, v1}, Landroid/view/View;->setTranslationY(F)V

    .line 140
    iget-object v0, p0, Landroid/support/v7/app/F;->a:Landroid/support/v7/app/I;

    iget-object v0, v0, Landroid/support/v7/app/I;->h:Landroid/support/v7/widget/ActionBarContainer;

    invoke-virtual {v0, v1}, Landroid/widget/FrameLayout;->setTranslationY(F)V

    .line 142
    :cond_0
    iget-object v0, p0, Landroid/support/v7/app/F;->a:Landroid/support/v7/app/I;

    iget-object v0, v0, Landroid/support/v7/app/I;->h:Landroid/support/v7/widget/ActionBarContainer;

    const/16 v1, 0x8

    invoke-virtual {v0, v1}, Landroid/support/v7/widget/ActionBarContainer;->setVisibility(I)V

    .line 143
    iget-object v0, p0, Landroid/support/v7/app/F;->a:Landroid/support/v7/app/I;

    iget-object v0, v0, Landroid/support/v7/app/I;->h:Landroid/support/v7/widget/ActionBarContainer;

    const/4 v1, 0x0

    invoke-virtual {v0, v1}, Landroid/support/v7/widget/ActionBarContainer;->setTransitioning(Z)V

    .line 144
    iget-object v0, p0, Landroid/support/v7/app/F;->a:Landroid/support/v7/app/I;

    const/4 v1, 0x0

    iput-object v1, v0, Landroid/support/v7/app/I;->B:La/b/d/d/i;

    .line 145
    invoke-virtual {v0}, Landroid/support/v7/app/I;->l()V

    .line 146
    iget-object v0, p0, Landroid/support/v7/app/F;->a:Landroid/support/v7/app/I;

    iget-object v0, v0, Landroid/support/v7/app/I;->g:Landroid/support/v7/widget/ActionBarOverlayLayout;

    if-eqz v0, :cond_1

    .line 147
    invoke-static {v0}, La/b/c/g/u;->m(Landroid/view/View;)V

    .line 149
    :cond_1
    return-void
.end method
