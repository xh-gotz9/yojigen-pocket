package cn.gotz9.pocket.storage;

/**
 * @param <S> DataSource
 */
public abstract class AbstractStorage<S> implements DataStorageProvider<S> {

    private final DataStorageProvider<S> dataStorageProvider;

    public AbstractStorage(DataStorageProvider<S> dataStorageProvider) {
        this.dataStorageProvider = dataStorageProvider;
    }

    @Override
    public S getSource() {
        return dataStorageProvider.getSource();
    }

}
