-- 코드를 입력하세요
SELECT I.NAME, I.DATETIME from ANIMAL_INS as I left join ANIMAL_OUTS as O using (ANIMAL_ID) where O.ANIMAL_ID is null order by DATETIME  limit 3
