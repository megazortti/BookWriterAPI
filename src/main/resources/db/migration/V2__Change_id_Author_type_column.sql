ALTER TABLE books ADD COLUMN new_author_id bigint;

-- Step 2: Copy data from author_id to new_author_id
UPDATE books SET new_author_id = author_id::bigint;

-- Step 3: Drop the original author_id column
ALTER TABLE books DROP COLUMN author_id;

-- Step 4: Rename the new_author_id column to author_id
ALTER TABLE books RENAME COLUMN new_author_id TO author_id;