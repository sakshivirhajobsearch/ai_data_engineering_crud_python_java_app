import pandas as pd

def extract_csv(file_path):
    df = pd.read_csv(file_path)
    df.columns = df.columns.str.strip().str.lower()  # normalize column names
    return df
