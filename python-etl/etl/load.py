import mysql.connector

def load_to_mysql(df, db_config):
    conn = mysql.connector.connect(**db_config)
    cursor = conn.cursor()

    for _, row in df.iterrows():
        cursor.execute(
            "INSERT INTO records (name, age) VALUES (%s, %s)",
            (row['name'], row['age'])
        )

    conn.commit()
    cursor.close()
    conn.close()
