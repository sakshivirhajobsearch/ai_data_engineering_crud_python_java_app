from etl.extract import extract_csv
from etl.transform import clean_data
from etl.load import load_to_mysql

def main():
    try:
        print("📥 Extracting CSV...")
        df = extract_csv("data.csv")
        print(f"✅ Extracted {len(df)} rows")

        print("🧹 Cleaning data...")
        df = clean_data(df)
        print("✅ Data cleaned")

        db_config = {
            'user': 'root',
            'password': 'admin',  # Make sure this is correct!
            'host': 'localhost',
            'database': 'etl_db'
        }

        print("📤 Loading to MySQL...")
        load_to_mysql(df, db_config)
        print("✅ Load complete")

    except Exception as e:
        print("❌ An error occurred during ETL process:")
        print(e)

if __name__ == "__main__":
    main()
