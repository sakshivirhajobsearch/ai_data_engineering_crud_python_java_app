def clean_data(df):
    df['name'] = df['name'].str.strip().str.title()
    df['age'] = df['age'].fillna(0).astype(int)
    return df
