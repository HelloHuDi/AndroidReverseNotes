.class Landroid/support/v7/widget/ma;
.super Ljava/lang/Object;
.source ""

# interfaces
.implements Ljava/lang/Runnable;


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Landroid/support/v7/widget/SearchView$SearchAutoComplete;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic a:Landroid/support/v7/widget/SearchView$SearchAutoComplete;


# direct methods
.method constructor <init>(Landroid/support/v7/widget/SearchView$SearchAutoComplete;)V
    .locals 0
    .param p1, "this$0"    # Landroid/support/v7/widget/SearchView$SearchAutoComplete;

    .line 1829
    iput-object p1, p0, Landroid/support/v7/widget/ma;->a:Landroid/support/v7/widget/SearchView$SearchAutoComplete;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public run()V
    .locals 1

    .line 1832
    iget-object v0, p0, Landroid/support/v7/widget/ma;->a:Landroid/support/v7/widget/SearchView$SearchAutoComplete;

    invoke-virtual {v0}, Landroid/support/v7/widget/SearchView$SearchAutoComplete;->b()V

    .line 1833
    return-void
.end method
