package android.arch.lifecycle;

@Deprecated
public interface LifecycleRegistryOwner extends LifecycleOwner {
    LifecycleRegistry getLifecycle();
}
